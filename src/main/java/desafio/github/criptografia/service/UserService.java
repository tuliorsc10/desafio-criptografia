package desafio.github.criptografia.service;

import desafio.github.criptografia.components.UserCrypto;
import desafio.github.criptografia.domain.entity.Usuario;
import desafio.github.criptografia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCrypto userCrypto;
    public Usuario createUser(Usuario user) {
        return userRepository.save(Usuario.builder()
                .document(user.getDocument())
                .card(user.getCard())
                .valor(user.getValor())
                .build());
    }

    public Usuario getUsuarioId(long id) {

        Optional<Usuario> usuario = userRepository.findById(id);
        if(usuario.isEmpty()) {
            throw new RuntimeException();
        }
        return usuario.get();
    }

    public Usuario updateUsuario(long id, Usuario user) {
        Optional<Usuario> usuario = userRepository.findById(id);
        if(usuario.isEmpty()) {
            throw new RuntimeException();
        }
        return userRepository.save(Usuario.builder()
                .id(id)
                .card(user.getCard())
                .document(user.getDocument())
                .valor(user.getValor())
                .build());
    }

    public String deletaUsuario(long id) {
        Optional<Usuario> usuario = userRepository.findById(id);
        if(usuario.isEmpty()) {
            throw new RuntimeException();
        }
        userRepository.deleteById(id);
        return "Usuário Deletado!";
    }
}
