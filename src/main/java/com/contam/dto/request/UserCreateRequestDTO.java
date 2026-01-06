package com.contam.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDTO {
    @NotBlank(message = "Nome Completo é obrigatório para cadastro")
    @Size(min = 3, max = 255)
    private String nomeCompleto;

    @NotBlank(message = "Primeiro nome é obrigatório")
    @Size(min = 3, max = 255)
    private String primeiroNome;

    @NotBlank(message = "Último nome é obrigatório")
    @Size(min = 3, max = 255)
    private String ultimoNome;

    @NotBlank(message = "Nome de usuário é obrigatório")
    @Size(min = 3, max = 50)
    @Pattern(
            regexp = "^[a-z]+(\\.[a-z]+)+$",
            message = "Nome de usuário deve seguir o padrão nome.sobrenome, apenas letras minúsculas e ponto"
    )
    private String nomeUsuario;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 30)
    private String matricula;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "Senha deve conter letra maiúscula, minúscula e número"
    )
    private String senha;
}


