package com.Estoca_Ai.Controller;

import com.Estoca_Ai.Entity.Transacoes;
import com.Estoca_Ai.Repository.TransacoesRepository;
import com.Estoca_Ai.Services.TransacoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("estoca-ai")
@RestController
public class TransacoesController {
    private final TransacoesService transacoesService;

    public TransacoesController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @GetMapping("/transacoes")
        public List<Transacoes> listarTransacoes(){return transacoesService.listarTransacoes();}

    @GetMapping("/transacoes/responsavel")
        public List<Transacoes> listarResponsavel(@RequestParam String nome){return transacoesService.listarTransacoesPorResponsavel(nome);}

    @GetMapping("/transacoes/solicitante")
        public List<Transacoes> listarSolicitante(@RequestParam String nome){return transacoesService.listarTransacoesPorSolicitante(nome);}
}
