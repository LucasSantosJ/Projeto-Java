package Projeto.lucas.todoSpring.API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class UsuarioCreateDTO {
    @NotBlank
    @Email(message = " o email informado nao é valido ")
    private String email;
    @Size(min = 5, max =100, message = " a senha dever ter entre 5 e 10 caracteres ")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioCreateDTO that = (UsuarioCreateDTO) o;
        return Objects.equals(getSenha(), that.getSenha()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSenha(), getEmail());
    }
}
