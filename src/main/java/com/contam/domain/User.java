package com.contam.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

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
