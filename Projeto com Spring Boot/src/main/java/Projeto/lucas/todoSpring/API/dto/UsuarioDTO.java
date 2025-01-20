package Projeto.lucas.todoSpring.API.dto;

import Projeto.lucas.todoSpring.domain.entities.Usuario;

import java.util.Objects;

public class UsuarioDTO {

    private long id;
    private String email;

    public UsuarioDTO(Usuario usu) {
        this.id = usu.getId();
        this.email = usu.getEmail();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return getId() == that.getId() && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }
}
