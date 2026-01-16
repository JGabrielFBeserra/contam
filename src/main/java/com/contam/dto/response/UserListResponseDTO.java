package com.contam.dto.response;

import com.contam.domain.User;

import java.time.LocalDateTime;

public record UserListResponseDTO(
        Long id,
        String nomeCompleto,
        String nomeUsuario,
        String email,
        String matricula,
        LocalDateTime createdAt) {

    public UserCreateResponseDTO (User user) {
        id = user.getId();
    }
}
