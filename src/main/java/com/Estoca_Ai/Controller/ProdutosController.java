package com.Estoca_Ai.Controller;


import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/estoca-ai")
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

    @DeleteMapping("produtos/{id}")
        public ResponseEntity<Produto> deletarProduto(@PathVariable Integer id){
            Produto deletado = produtoService.deletarProduto(id);
            return ResponseEntity.noContent().build();
        }

    @PatchMapping("produtos/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto){
        Produto atualizado = produtoService.editarProduto(id, produto);
        return ResponseEntity.ok().body(atualizado);
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PatchMapping("produtos/{id}/entrada")
        public ResponseEntity<Produto> entradaProduto(
                @PathVariable Long idProduto,
                @RequestParam int quantidade,
                @RequestParam String responsavel){
        Produto atualizado = produtoService.entradaProduto(idProduto, quantidade, responsavel);
        return ResponseEntity.ok().body(atualizado);
        }

    @PatchMapping("produtos/{id}/saida")
        public ResponseEntity<Produto> saidaProduto(
                @PathVariable Long idProduto,
                @RequestParam int quantidade,
                @RequestParam String responsavel,
                @RequestParam String solicitante){
        Produto atualizado = produtoService.saidaProduto(idProduto, quantidade, responsavel, solicitante);
        return ResponseEntity.ok().body(atualizado);
    }
}
