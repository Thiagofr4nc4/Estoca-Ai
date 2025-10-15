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
        if (produto.getPreco() != 0) {
            editarProduto.setPreco(produto.getPreco());
        }
        if (produto.getDesconto() < 0) {
            editarProduto.setDesconto(produto.getDesconto());
        }
        if (produto.getDescricao() != null) {
            editarProduto.setDescricao(produto.getDescricao());
        }
        if (produto.getEstoque() < 0) {
            editarProduto.setEstoque(produto.getEstoque());
        }
        return produtoRepository.save(editarProduto);
    }

    public Produto criarProduto(Produto produto){
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }

        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo");
        }

        if (produto.getEstoque() < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }

        return produtoRepository.save(produto);
    }

    public Produto entradaProduto(String nome, int quantidade, String responsavel){
        Produto produto = (Produto) produtoRepository.findByNome(nome);

        produto.setEstoque(produto.getEstoque() + quantidade);
        produtoRepository.save(produto);

        transacoesService.registrarTransacoes("Entrada", produto, responsavel, quantidade);

        return produto;
    }

    public Produto saidaProduto(String nome, int quantidade, String responsavel){
        Produto produto = produtoRepository.findByNome(nome);
        if (produto.getEstoque() < quantidade){
            throw new IllegalArgumentException("Quantidade não suficiente em estoque");
        }
        produto.setEstoque(produto.getEstoque() - quantidade);
        produtoRepository.save(produto);

        transacoesService.registrarTransacoes("Saida", produto, responsavel, quantidade);
        return produto;
    }
}
