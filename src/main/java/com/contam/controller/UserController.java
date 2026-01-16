package com.contam.controller;


import com.contam.dto.request.UserCreateRequestDTO;
import com.contam.dto.response.UserCreateResponseDTO;
import com.contam.dto.response.UserListResponseDTO;
import com.contam.mapper.UserMapper;
import com.contam.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserCreateResponseDTO> create(@Valid @RequestBody UserCreateRequestDTO dto) {
        System.out.println("DTO recebido: " + dto);
        var user = userMapper.DTOtoEntity(dto);
        var userSalvo = userService.create(user);
        var response = userMapper.EntitytoResponseDTO(userSalvo);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSalvo.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Page<UserListResponseDTO>> listOn(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = userService.listOn(pageable);
        return ResponseEntity.ok(page);
    }

}

