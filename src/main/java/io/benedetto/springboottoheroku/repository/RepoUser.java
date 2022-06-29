package io.benedetto.springboottoheroku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.benedetto.springboottoheroku.model.User;

public interface RepoUser extends JpaRepository<User, Integer> {
    public User findById(int id);
}
