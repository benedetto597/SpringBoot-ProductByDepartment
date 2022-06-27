package io.benedetto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.benedetto.backend.model.Category;

public interface RepoCategory extends JpaRepository<Category, Integer> {
    public Category findById(int id);
}
