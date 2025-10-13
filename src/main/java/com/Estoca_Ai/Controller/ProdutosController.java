package com.Estoca_Ai.Controller;


import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/Estoca-Ai")
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

    @DeleteMapping("produtos/deletar-produto/{id}")
        public ResponseEntity<Produto> deletarProduto(@PathVariable Integer id){
            Produto deletado = produtoService.deletarProduto(id);
            return ResponseEntity.noContent().build();
        }

    @PatchMapping("produtos/atualizar-produto/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto){
        Produto atualizado = produtoService.editarProduto(id, produto);
        return ResponseEntity.ok().body(atualizado);
    }

    @PostMapping("/produtos/Criar-produto")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
}
