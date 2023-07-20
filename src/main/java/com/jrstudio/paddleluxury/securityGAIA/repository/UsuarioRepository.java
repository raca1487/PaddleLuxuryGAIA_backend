package com.jrstudio.paddleluxury.securityGAIA.repository;

import com.jrstudio.paddleluxury.securityGAIA.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);

}
