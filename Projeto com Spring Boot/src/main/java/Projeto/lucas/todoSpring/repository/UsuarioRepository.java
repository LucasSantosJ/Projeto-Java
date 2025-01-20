package Projeto.lucas.todoSpring.repository;

import Projeto.lucas.todoSpring.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario save(Usuario usuario);//ja existe dentro do jpaReposytory

     public Usuario findByEmail(String email);
}
