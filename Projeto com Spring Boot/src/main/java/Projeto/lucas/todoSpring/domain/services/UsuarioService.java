package Projeto.lucas.todoSpring.domain.services;

import Projeto.lucas.todoSpring.API.dto.UsuarioCreateDTO;
import Projeto.lucas.todoSpring.API.dto.UsuarioDTO;
import Projeto.lucas.todoSpring.domain.entities.Usuario;
import Projeto.lucas.todoSpring.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

    public UsuarioDTO criar(UsuarioCreateDTO dto) throws DataIntegrityViolationException {
        Usuario usu = repository.findByEmail(dto.getEmail());
        if(usu != null ){
            throw new DataIntegrityViolationException("Ja existe um usuario um usuario cadastrado com este e-mail!");
        }

        Usuario novo = new Usuario(dto);
        novo.setSenha(passwordEncoder.encode(dto.getSenha()));
        return new UsuarioDTO(repository.save(novo));

    }
}
