package com.Estoca_Ai.Repository;

import com.Estoca_Ai.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import  java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
