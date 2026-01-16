package com.contam.mapper;

import com.contam.domain.User;
import com.contam.dto.request.UserCreateRequestDTO;
import com.contam.dto.response.UserCreateResponseDTO;
import com.contam.dto.response.UserListResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User DTOtoEntity(UserCreateRequestDTO dto) {
        return new User(
                dto.getNomeCompleto(),
                dto.getPrimeiroNome(),
                dto.getUltimoNome(),
                dto.getNomeUsuario(),
                dto.getEmail(),
                dto.getMatricula(),
                dto.getSenha()
        );
    }

    public UserCreateResponseDTO EntitytoResponseDTO(User user) {
        return new UserCreateResponseDTO(
                user.getId(),
                user.getNomeUsuario()

        );
    }

    public UserListResponseDTO EntitytoListResponseDTO(User user) {
        return new UserListResponseDTO(
                user.getId(),
                user.getNomeCompleto(),
                user.getNomeUsuario(),
                user.getEmail(),
                user.getMatricula(),
                user.getCreatedAt()
        );
    }

}
