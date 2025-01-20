package Projeto.lucas.todoSpring.API.dto;
import Projeto.lucas.todoSpring.domain.entities.Estado;
import Projeto.lucas.todoSpring.domain.entities.Todo;

import java.time.LocalDate;

public class TodoDTO {
   private long id;
   private long idUsuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public TodoDTO(){}

    public TodoDTO(Todo todo){
        this.id = todo.getId();
        this.idUsuario = todo.getUsuario().getId();
        this.item = todo.getItem();
        this.prazo = todo.getPrazo();
        this.estado = todo.getEstado();

    }

    public long getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(long idUsuario){
        this.idUsuario = idUsuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
