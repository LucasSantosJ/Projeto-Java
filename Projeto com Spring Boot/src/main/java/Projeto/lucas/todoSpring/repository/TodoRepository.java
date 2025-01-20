package Projeto.lucas.todoSpring.repository;

import Projeto.lucas.todoSpring.domain.entities.Estado;
import Projeto.lucas.todoSpring.domain.entities.Todo;
import Projeto.lucas.todoSpring.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public Todo save(Todo t);

    public List<Todo> findByUsuario(Usuario usu);
    public List<Todo> findByUsuarioAndEstado(Usuario usu, Estado estado);
    public List<Todo> findById(long id);

}
