package com.example.rallyce.users.service.impl;

import com.example.rallyce.users.domain.dto.UserRequest;
import com.example.rallyce.users.domain.entities.Role;
import com.example.rallyce.users.domain.entities.User;
import com.example.rallyce.users.repositories.UserRepository;
import com.example.rallyce.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserRequest nuevoUsuario(UserRequest userRequest){

        User user = new User();
        user.setNombre(userRequest.nombre());
        user.setPais(userRequest.pais());
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        user.setRole(Role.USER.name());

        userRepository.save(user);

        return userRequest;
    }

    @Override
    public List<User> listaUsuarios() {
        return StreamSupport.stream(userRepository.findAll()
                .spliterator(), false
        ).collect(Collectors.toList());
    }

    @Override
    public boolean isExists(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Optional<User> obtenerUsuario(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserRequest actualizarUsuario(UserRequest userRequest, Long id) {

        User user = new User();
        user.setId(id);
        user.setNombre(userRequest.nombre());
        user.setPais(userRequest.pais());
        user.setUsername(userRequest.username());
        user.setPassword(userRequest.password());
        user.setRole(Role.USER.name());

        userRepository.save(user);

        return userRequest;
    }


    @Override
    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }

}
