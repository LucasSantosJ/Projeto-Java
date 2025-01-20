package Projeto.lucas.todoSpring.domain.services;

import Projeto.lucas.todoSpring.domain.entities.Usuario;
import Projeto.lucas.todoSpring.repository.UsuarioRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario currentUser = repository.findByEmail(email);

        if (currentUser != null) {
            UserDetails user = new User(email, currentUser.getSenha(),
                    true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return user;
        }else throw new UsernameNotFoundException("usuario ou inválido(s)!");
    }

}
