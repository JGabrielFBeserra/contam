package com.contam.service;

import com.contam.domain.User;
import com.contam.exception.EmailAlreadyExistsException;
import com.contam.exception.RegistrationAlreadyExistsException;
import com.contam.exception.UsernameAlreadyExistsException;
import com.contam.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Esse Email já tem cadastrado: " + user.getEmail());
        }

        if (userRepository.existsByNomeUsuario(user.getNomeUsuario())) {
            throw new UsernameAlreadyExistsException("Esse Nome de usuário já tem cadastro: " + user.getNomeUsuario());
        }

        if (userRepository.existsByMatricula(user.getMatricula())) {
            throw new RegistrationAlreadyExistsException("Essa Matrícula já tem cadastro: " + user.getMatricula());
        }
        return userRepository.save(user);
    }
}
