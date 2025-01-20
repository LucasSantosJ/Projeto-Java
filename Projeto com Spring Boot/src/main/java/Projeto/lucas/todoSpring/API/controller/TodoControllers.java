package Projeto.lucas.todoSpring.API.controller;

import Projeto.lucas.todoSpring.API.dto.TodoCreateDTO;
import Projeto.lucas.todoSpring.API.dto.TodoDTO;
import Projeto.lucas.todoSpring.API.dto.TodoUpdateDTO;
import Projeto.lucas.todoSpring.domain.entities.Estado;
import Projeto.lucas.todoSpring.domain.entities.Todo;
import Projeto.lucas.todoSpring.domain.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoControllers {

    private final TodoService service;

    public TodoControllers(TodoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TodoDTO> criar(@RequestBody TodoCreateDTO todo){
        return new ResponseEntity<TodoDTO>(service.criar(todo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<String>> listar(){
        List<String> todos = new ArrayList<String>();
        todos.add("Postar primeira atividade");
        todos.add("ler emails");
        todos.add("revisar a aula de hoje");
        ResponseEntity<List <String> > response = new ResponseEntity<List <String> >(todos, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuario(@PathVariable long userId){
        return new ResponseEntity<List<TodoDTO>>(service.listarTodosDeUmUsuario(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{estado}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuarioEEstado(@PathVariable long userId, @PathVariable Estado estado){
        return new ResponseEntity<List<TodoDTO>>(service.listarTodosDeUmUsuarioComEstado(userId, estado), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<TodoDTO> alterar(@RequestBody TodoUpdateDTO dto) throws Exception {
        return new ResponseEntity<TodoDTO>(service.alterar(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{deletarId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean isDeleted = service.deleteTodoById(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{atualizarId}")
    public ResponseEntity<Todo> updateTodoPartial(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo updatedTodo = service.updateTodoPartial(id, todoDetails);
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
