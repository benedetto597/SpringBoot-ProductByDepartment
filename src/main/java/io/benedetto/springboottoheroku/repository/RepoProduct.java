package io.benedetto.springboottoheroku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.benedetto.springboottoheroku.model.Product;

public interface RepoProduct extends JpaRepository<Product, Integer> {
    public Product findById(int id);
}
