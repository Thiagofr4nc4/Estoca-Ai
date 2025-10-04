package com.Estoca_Ai.Services;

import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto addProduto(Produto produto){
        if(produto.getPreco() < 0 ) throw new IllegalArgumentException("Preço não pode ser menor que 0");
        return produtoRepository.save(produto);
    }

    public List<Produto> listProdutos(){
        return produtoRepository.findAll();
    }

    public Produto deletarProduto(int id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        produtoRepository.delete(produto);
        return produto;

    }
}
