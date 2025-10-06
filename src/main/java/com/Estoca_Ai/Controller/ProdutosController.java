package com.Estoca_Ai.Controller;


import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/Produtos")
@RestController
public class ProdutosController {
    private final ProdutoService produtoService;

    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
        public List<Produto> listarProdutos(){
            return produtoService.listarProdutos();
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Produto> deletarProduto(@PathVariable Integer id){
            Produto deletado = produtoService.deletarProduto(id);
            return ResponseEntity.ok().body(deletado);
        }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto){
        Produto atualizado = produtoService.editarProduto(id, produto);
        return ResponseEntity.ok().body(atualizado);
    }
}
