package com.example.rallyce.users.service;

import com.example.rallyce.users.domain.dto.UserRequest;
import com.example.rallyce.users.domain.dto.UserResponse;
import com.example.rallyce.users.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserRequest nuevoUsuario(UserRequest userRequest);

    List<UserResponse> listaUsuarios();

    boolean isExists(Long id);

    Optional<User> obtenerUsuario(Long id);

    UserRequest actualizarUsuario(UserRequest userRequest, Long id);

    void eliminarUsuario(Long id);

}
