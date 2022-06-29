package io.benedetto.springboottoheroku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.benedetto.springboottoheroku.model.Category;
import io.benedetto.springboottoheroku.model.Product;
import io.benedetto.springboottoheroku.model.User;

import io.benedetto.springboottoheroku.service.ServCategory;
import io.benedetto.springboottoheroku.service.ServProduct;
import io.benedetto.springboottoheroku.service.ServUser;

@RestController
@RequestMapping("/api")
public class Api {
    @Autowired
    ServProduct servProduct;
    
    @Autowired
    ServCategory servCategory;

    @Autowired
    ServUser servUser;


    // Producto //
    @PostMapping("/product/createProduct")
    public void createProduct(@RequestBody Product product) {
        servProduct.createProduct(product);
    }

    @PutMapping("/product/updateProduct/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product oldProduct = servProduct.getProductById(id);
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setImage(product.getImage());
        oldProduct.setCategory(product.getCategory());
        servProduct.createProduct(oldProduct);
    }

    @GetMapping("/product/getAllProducts")
    public List<Product> getAllProducts() {
        return servProduct.getAllProducts();
    }

    @GetMapping("/product/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return servProduct.getProductById(id);
    }

    @DeleteMapping("/product/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        servProduct.deleteProduct(id);
    }

    // Categoria //
    @PostMapping("/category/createCategory")
    public void createCategory(@RequestBody Category category) {
        this.servCategory.createCategory(category);
    }
    
    @PutMapping("/category/updateCategory/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category oldCategory = servCategory.getCategoryById(id);
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        servCategory.createCategory(oldCategory);
    }

    @GetMapping("/category/getAllCategories")
    public List<Category> getAllCategories() {
        return this.servCategory.getAllCategories();
    }

    @GetMapping("/category/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return this.servCategory.getCategoryById(id);
    }
    
    @DeleteMapping("/category/deleteCategory/{id}")
    public Integer deleteCategory(@PathVariable int id) {
        this.servCategory.deleteCategory(id);
        return id;
    }

    // Usuario //
    @PostMapping("/user/createUser")
    public void createUser(@RequestBody User user) {
        this.servUser.createUser(user);   
    }
    @PutMapping("/user/updateUser/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        User oldUser = servUser.getUserById(id);
        oldUser.setName(user.getName());
        oldUser.setLast_name(user.getLast_name());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        servUser.createUser(oldUser);
    }
    @GetMapping("/user/getAllUsers")
    public List<User> getAllUsers() {
        return this.servUser.getAllUsers();
    }
    @GetMapping("/user/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return this.servUser.getUserById(id);
    }
    @DeleteMapping("/user/deleteUser/{id}")
    public Integer deleteUser(@PathVariable int id) {
        this.servUser.deleteUser(id);
        return id;
    }
}
