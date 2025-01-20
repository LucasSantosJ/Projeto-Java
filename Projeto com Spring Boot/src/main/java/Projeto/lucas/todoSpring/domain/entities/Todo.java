package Projeto.lucas.todoSpring.domain.entities;
import Projeto.lucas.todoSpring.API.dto.TodoCreateDTO;
import Projeto.lucas.todoSpring.API.dto.TodoUpdateDTO;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//melhor para mysql
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")    //chave estrageira
    private Usuario usuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;
    private LocalDate conclusao;

    public Todo(){}// contrutor vazio para o spring

    public Todo(TodoCreateDTO dto){
             setUsuario(new Usuario(dto.getIdUsuario()));
             this.item = dto.getItem();
             this.prazo = dto.getPrazo();
             this.estado = dto.getEstado();

}
      public Todo(TodoUpdateDTO dto){
        this.id = dto.getId();
        this.item = dto.getItem();
        this.prazo = dto.getPrazo();
        this.estado = dto.getEstado();
        this.conclusao = dto.getConclusao();
        }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
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

    public LocalDate getConclusao() {
        return conclusao;
    }
    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(getId(), todo.getId()) && Objects.equals(getUsuario(), todo.getUsuario()) && Objects.equals(getItem(), todo.getItem()) && Objects.equals(getPrazo(), todo.getPrazo()) && getEstado() == todo.getEstado() && Objects.equals(getConclusao(), todo.getConclusao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getItem(), getPrazo(), getEstado(), getConclusao());
    }
}
