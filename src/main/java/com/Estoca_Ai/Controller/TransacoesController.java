package com.Estoca_Ai.Controller;

import com.Estoca_Ai.Entity.Transacoes;
import com.Estoca_Ai.Repository.TransacoesRepository;
import com.Estoca_Ai.Services.TransacoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("Estoca-Ai")
@RestController
public class TransacoesController {
    private final TransacoesService transacoesService;

    public TransacoesController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @GetMapping("/Transacoes")
        public List<Transacoes> listarTransacoes(){return transacoesService.listarTransacoes();}

    @GetMapping("/Transacoes/Tipo")
        public List<Transacoes> listarPorTipo(@RequestParam String tipo){return transacoesService.listarTransacoesPorTipo(tipo);}

    @GetMapping("/Transacoes/Responsavel")
        public List<Transacoes> listarResponsavel(@RequestParam String nome){return transacoesService.listarTransacoesPorResponsavel(nome);}
}
