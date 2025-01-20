package Projeto.lucas.todoSpring.domain.services;

import Projeto.lucas.todoSpring.API.dto.TodoCreateDTO;
import Projeto.lucas.todoSpring.API.dto.TodoDTO;
import Projeto.lucas.todoSpring.API.dto.TodoUpdateDTO;
import Projeto.lucas.todoSpring.domain.entities.Estado;
import Projeto.lucas.todoSpring.domain.entities.Todo;
import Projeto.lucas.todoSpring.domain.entities.Usuario;
import Projeto.lucas.todoSpring.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoDTO criar(TodoCreateDTO todo) {
        return new TodoDTO(repository.save(new Todo(todo)));// fazendo em uma unica linha
    }

    public List<TodoDTO> listarTodosDeUmUsuario(long userId) {
        return repository.findByUsuario(new Usuario(userId))
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }

    public List<TodoDTO> listarTodosDeUmUsuarioComEstado(long userId, Estado estado) {
        return repository.findByUsuarioAndEstado(new Usuario(userId), estado)
                .stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }

    public TodoDTO alterar(TodoUpdateDTO dto) throws Exception {
        Todo existe = (Todo) repository.findById(dto.getId());
        if (existe != null) {
            Todo alterar = new Todo(dto);
            alterar.setUsuario(existe.getUsuario());
            return new TodoDTO(repository.save(alterar));
        } else {
            throw new Exception("Objeto nao encontrado com id: " + dto.getId());
        }
    }

    public boolean deleteTodoById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Todo updateTodoPartial(Long id, Todo todoDetails) {
        return repository.findById(id).map(todo -> {
            if (todoDetails.getEstado() != null) {
                todo.setEstado(todoDetails.getEstado());
            }
            if (todoDetails.getItem() != null) {
                todo.setItem(todoDetails.getItem());
            }
            return repository.save(todo);
        }).orElse(null);

    }
}
