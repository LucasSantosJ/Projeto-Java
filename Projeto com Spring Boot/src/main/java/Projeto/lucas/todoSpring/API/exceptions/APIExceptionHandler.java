package Projeto.lucas.todoSpring.API.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class APIExceptionHandler {

 @ExceptionHandler
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
     StringBuilder mensagem = new StringBuilder("Erro(s) de validação: ");
     ex.getBindingResult().getAllErrors().forEach(
             error -> {
                 mensagem.append(error.getDefaultMessage()).append("\n");
             }
     );

     Map<String, Object> body = new HashMap<>();
     body.put("status", HttpStatus.BAD_REQUEST.value());
     body.put("erro", "problemas nos parametros enviados ");
     body.put("mensagem", mensagem.toString().trim());
     body.put("timestamp", LocalDateTime.now());
     return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

 }

 @ExceptionHandler
    public ResponseEntity<Object> handleDataInegrityException(DataIntegrityViolationException ex) {

     StringBuilder mensagem = new StringBuilder("Erro(s) de violação de integridade");
     mensagem.append(ex.getMessage()).append("\n");
     Map<String, Object> body = new HashMap<>();
     body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
     body.put("Error", "Problema de integridade no BD devido aos parâmetros enviados!");
     body.put("mensagem", mensagem.toString().trim());
     body.put("timestamp", LocalDateTime.now());
     return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

 }
}

