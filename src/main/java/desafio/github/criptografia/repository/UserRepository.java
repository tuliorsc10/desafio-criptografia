package desafio.github.criptografia.repository;

import desafio.github.criptografia.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
}
