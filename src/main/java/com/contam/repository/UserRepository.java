package com.contam.repository;

import com.contam.domain.User;
import com.contam.dto.response.UserListResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByNomeUsuario(String nomeUsuario);

    boolean existsByMatricula(String matricula);

    Page<UserListResponseDTO> findByStatusTrue(@PageableDefault(size= 10, sort = "nome")Pageable pageable);
}
