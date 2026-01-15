package com.contam.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;
    @Column(name = "primeiro_nome", nullable = false)
    private String primeiroNome;
    @Column(name = "ultimo_nome", nullable = false)
    private String ultimoNome;
    @Column(name = "nome_usuario", nullable = false, unique = true)
    private String nomeUsuario;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;
    @ToString.Exclude
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "status")
    private Boolean status;

    public User(
            String nomeCompleto,
            String primeiroNome,
            String ultimoNome,
            String nomeUsuario,
            String email,
            String matricula,
            String senha
    ) {
        this.nomeCompleto = nomeCompleto;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.matricula = matricula;
        this.senha = senha;
        this.status = true;
    }
}
