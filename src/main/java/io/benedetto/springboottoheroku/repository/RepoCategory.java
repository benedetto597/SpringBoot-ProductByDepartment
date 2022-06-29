package io.benedetto.springboottoheroku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.benedetto.springboottoheroku.model.Category;

public interface RepoCategory extends JpaRepository<Category, Integer> {
    public Category findById(int id);
}
