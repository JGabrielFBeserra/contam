package com.contam.repository;

import com.contam.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByNomeUsuario(String nomeUsuario);

    boolean existsByMatricula(String matricula);

}
