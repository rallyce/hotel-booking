package com.example.rallyce.users.controller;

import com.example.rallyce.users.domain.dto.UserRequest;
import com.example.rallyce.users.domain.dto.UserResponse;
import com.example.rallyce.users.domain.entities.User;
import com.example.rallyce.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRequest nuevoUsuario(@RequestBody UserRequest userRequest){
        return userService.nuevoUsuario(userRequest);
    }

    @GetMapping("/listaUsuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> listaUsuarios(){
        return userService.listaUsuarios();
    }

    @GetMapping("/obtenerUsuario/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable("id") Long idUsuario){
        boolean usuarioExiste = userService.isExists(idUsuario);
        if (!usuarioExiste){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no se encuentra registrado o no existe");
        }

        Optional<User> infoUser = userService.obtenerUsuario(idUsuario);

        return new ResponseEntity<>(infoUser, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@RequestBody UserRequest userRequest, @PathVariable("id") Long idUsuario){

        boolean usuarioExiste = userService.isExists(idUsuario);
        if (!usuarioExiste){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("El usuario no se encuentra registrado");
        }


        UserRequest actUsuario = userService.actualizarUsuario(userRequest, idUsuario);

        return new ResponseEntity<>(actUsuario, HttpStatus.OK);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Long idUsuario){

        boolean usuarioExiste = userService.isExists(idUsuario);
        if (!usuarioExiste){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe o ya fue eliminado");
        }

        userService.eliminarUsuario(idUsuario);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuario eliminado correctamente");
    }

}
