package com.Estoca_Ai.Repository;

import com.Estoca_Ai.Entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacoesRepository extends JpaRepository<Transacoes, Integer> {
    List <Transacoes> findByResponsavel(String responsavel); // procurar saidas ou entradas por nome do responsável
    List<Transacoes> findByTipo(String tipo);
}
