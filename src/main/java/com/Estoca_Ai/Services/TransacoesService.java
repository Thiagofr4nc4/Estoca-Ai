package com.Estoca_Ai.Services;

import com.Estoca_Ai.Entity.Produto;
import com.Estoca_Ai.Entity.Transacoes;
import com.Estoca_Ai.Repository.TransacoesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Transacoes> listarTransacoesPorTipo(String tipo){
        return  transacoesRepository.findByTipo(tipo);
    }

    public List<Transacoes> listarTransacoesPorResponsavel(String responsavel){return  transacoesRepository.findByResponsavel(responsavel);}

    public Transacoes registrarTransacoes(String tipo, Produto produto, String responsavel, int quantidade){
        Transacoes registro = new Transacoes();
        registro.setTipo(tipo);
        registro.setResponsavel(responsavel);
        registro.setProduto(produto);
        registro.setData(LocalDateTime.now());
        registro.setQuantidade(quantidade);
        return transacoesRepository.save(registro);
    }
}
