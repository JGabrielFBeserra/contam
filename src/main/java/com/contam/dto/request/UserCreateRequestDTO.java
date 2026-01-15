package com.contam.dto.request;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @ToString.Exclude
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]+$",
            message = "Senha deve conter: letra maiúscula, minúscula, número e caracter especial (@$!%*?&#)"
    )
    private String senha;

    @ToString.Exclude
    @NotBlank(message = "Confirmação de senha é obrigatória")
    private String confirmacaoSenha;

    @AssertTrue(message = "As senhas não coicidem")
    private boolean isSenhasIguais() {
        if (senha == null || confirmacaoSenha == null) {
            return true;
        }
        return senha.equals(confirmacaoSenha);
    }
}


