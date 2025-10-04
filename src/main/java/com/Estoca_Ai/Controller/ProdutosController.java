package com.Estoca_Ai.Controller;


import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Repository.ProdutoRepository;
import com.Estoca_Ai.Services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutosController {
    private final ProdutoService produtoService;

    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
        public List<Produto> listarProdutos(){
            return produtoService.listProdutos();
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Produto> deletarProduto(@PathVariable Integer id){
            Produto deletado = produtoService.deletarProduto(id);
            return ResponseEntity.ok().body(deletado);
        }

}
