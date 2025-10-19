package com.Estoca_Ai.Services;

import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final TransacoesService transacoesService;

    public ProdutoService(ProdutoRepository produtoRepository, TransacoesService transacoesService) {
        this.produtoRepository = produtoRepository;
        this.transacoesService = transacoesService;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto deletarProduto(int id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        produtoRepository.delete(produto);
        return produto;
    }
    
    public Produto editarProduto(int id, Produto produto){
        Produto editarProduto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        if (produto.getNome() != null) {
            editarProduto.setNome(produto.getNome());
        }

        return produtoRepository.save(editarProduto);
    }

    public Produto criarProduto(Produto produto){
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }

        if (produto.getEstoque() < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }

        return produtoRepository.save(produto);
    }

    public Produto entradaProduto(Long idProduto, int quantidade, String responsavel){
        Produto produto = (Produto) produtoRepository.findById(idProduto);

        produto.setEstoque(produto.getEstoque() + quantidade);
        produtoRepository.save(produto);

        transacoesService.registrarEntrada("Entrada", produto, responsavel, quantidade);

        return produto;
    }

    public Produto saidaProduto(Long idProduto, int quantidade, String responsavel, String solicitante){
        Produto produto = produtoRepository.findById(idProduto);
        if (produto.getEstoque() < quantidade){
            throw new IllegalArgumentException("Quantidade não suficiente em estoque");
        }
        produto.setEstoque(produto.getEstoque() - quantidade);
        produtoRepository.save(produto);

        transacoesService.registrarSaida("Saida", produto, responsavel, quantidade, solicitante);
        return produto;
    }
}
