package io.benedetto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import io.benedetto.backend.model.Product;
import io.benedetto.backend.repository.RepoProduct;

@Service
public class ServProduct {
    @Autowired
    RepoProduct repoProduct;

    public void createProduct(Product product) {
        repoProduct.save(product);
    }

    public List<Product> getAllProducts() {
        return repoProduct.findAll();
    }

    public Product getProductById(int id) {
        return repoProduct.findById(id);
    }

    public void deleteProduct(int id) {
        repoProduct.deleteById(id);
    }
    
}
