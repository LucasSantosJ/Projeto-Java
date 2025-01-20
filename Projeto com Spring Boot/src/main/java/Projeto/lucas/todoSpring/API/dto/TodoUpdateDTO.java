package Projeto.lucas.todoSpring.API.dto;

import Projeto.lucas.todoSpring.domain.entities.Estado;

import java.time.LocalDate;

public class TodoUpdateDTO {

    private long id;
    private String item;
    private LocalDate prazo;
    private Estado estado;
    private LocalDate conclusao;

    public LocalDate getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
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
