package io.benedetto.springboottoheroku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import io.benedetto.springboottoheroku.model.Product;
import io.benedetto.springboottoheroku.repository.RepoProduct;

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

    public void updateProduct(int id, Product product) {
        this.deleteProduct(id);
        repoProduct.save(product);
    }
    
}
