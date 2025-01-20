package Projeto.lucas.todoSpring.API.dto;

import Projeto.lucas.todoSpring.domain.entities.Estado;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
public class TodoCreateDTO {

    private long idUsuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public LocalDate getPrazo() {
        return prazo;
    }
    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    }


