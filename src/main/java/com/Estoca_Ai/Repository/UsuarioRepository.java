package com.Estoca_Ai.Repository;

import com.Estoca_Ai.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
