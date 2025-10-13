package com.Estoca_Ai.Services;

import com.Estoca_Ai.Entity.Transacoes;
import com.Estoca_Ai.Repository.TransacoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacoesService {
    private final TransacoesRepository transacoesRepository;
    public TransacoesService(TransacoesRepository transacoesRepository){
        this.transacoesRepository = transacoesRepository;
    }

    public List<Transacoes> listarTransacoes(){
        return transacoesRepository.findAll();
    }

    public List<Transacoes> listarTransacoesSaida(String tipo){
        return  transacoesRepository.findByTipo(tipo);
    }

    public List<Transacoes> listarTransacoesPorResponsavel(String responsavel){return  transacoesRepository.findByResponsavel(responsavel);}
}
