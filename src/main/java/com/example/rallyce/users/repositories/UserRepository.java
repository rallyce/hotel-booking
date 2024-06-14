package com.example.rallyce.users.repositories;

import com.example.rallyce.users.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}