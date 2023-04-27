package desafio.github.criptografia.controller;

import desafio.github.criptografia.domain.entity.Usuario;
import desafio.github.criptografia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public Usuario createUser(@RequestBody Usuario user) {
        return service.createUser(user);
    }

    @GetMapping("{id}")
    public Usuario getUsuarioId(@PathVariable long id) {
        return service.getUsuarioId(id);
    }

    @PutMapping("{id}")
    public Usuario updateUsuario(@PathVariable long id, @RequestBody Usuario user) {
        return service.updateUsuario(id, user);
    }

    @DeleteMapping("{id}")
    public String deletaUsuario(@PathVariable long id) {
        return service.deletaUsuario(id);
    }

}
