package io.benedetto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.benedetto.backend.model.User;

public interface RepoUser extends JpaRepository<User, Integer> {
    public User findById(int id);
}
