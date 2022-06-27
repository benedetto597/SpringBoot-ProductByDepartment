package io.benedetto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.benedetto.backend.model.Product;

public interface RepoProduct extends JpaRepository<Product, Integer> {
    public Product findById(int id);
}
