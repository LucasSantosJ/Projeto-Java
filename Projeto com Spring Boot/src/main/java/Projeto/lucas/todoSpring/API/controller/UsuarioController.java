package Projeto.lucas.todoSpring.API.controller;

import Projeto.lucas.todoSpring.API.dto.UsuarioCreateDTO;
import Projeto.lucas.todoSpring.API.dto.UsuarioDTO;
import Projeto.lucas.todoSpring.domain.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioCreateDTO dto) {
    return new ResponseEntity<UsuarioDTO>(service.criar(dto), HttpStatus.CREATED);

    }


}
