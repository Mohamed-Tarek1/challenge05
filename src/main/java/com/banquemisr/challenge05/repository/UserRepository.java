package com.banquemisr.challenge05.repository;

import com.banquemisr.challenge05.enttiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
