package com.ecommerce.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUserEmail(String email);
}
