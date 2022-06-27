package io.benedetto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.benedetto.backend.model.Category;
import io.benedetto.backend.model.Product;
import io.benedetto.backend.model.User;

import io.benedetto.backend.service.ServCategory;
import io.benedetto.backend.service.ServProduct;
import io.benedetto.backend.service.ServUser;

@RestController
public class Controller {
    @Autowired
    ServProduct servProduct;
    
    @Autowired
    ServCategory servCategory;

    @Autowired
    ServUser servUser;

    // Producto //
    // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/product/createProduct")
    public void createProduct(@RequestBody Product product) {
        servProduct.createProduct(product);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/product/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        Product oldProduct = servProduct.getProductById(product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setImage(product.getImage());
        oldProduct.setCategory(product.getCategory());
        servProduct.createProduct(oldProduct);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/product/getAllProducts")
    public List<Product> getAllProducts() {
        return servProduct.getAllProducts();
    }
    
    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/product/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return servProduct.getProductById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/product/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        servProduct.deleteProduct(id);
    }

    // Categoria //
    // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("category/createCategory")
    public void createCategory(@RequestBody Category category) {
        this.servCategory.createCategory(category);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("category/updateCategory/{id}")
    public List<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category oldCategory = servCategory.getCategoryById(id);
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        servCategory.createCategory(oldCategory);
        return this.servCategory.getAllCategories();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/getAllCategories")
    public List<Category> getAllCategories() {
        return this.servCategory.getAllCategories();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return this.servCategory.getCategoryById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/category/deleteCategory/{id}")
    public Integer deleteCategory(@PathVariable int id) {
        this.servCategory.deleteCategory(id);
        return id;
    }

    // Usuario //
    // @CrossOrigin(origins = "http://localhost:3000/register")
    @PostMapping("/user/createUser")
    public void createUser(@RequestBody User user) {
        this.servUser.createUser(user);   
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/user/updateUser/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        User oldUser = servUser.getUserById(id);
        oldUser.setName(user.getName());
        oldUser.setLast_name(user.getLast_name());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        servUser.createUser(oldUser);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/getAllUsers")
    public List<User> getAllUsers() {
        return this.servUser.getAllUsers();
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return this.servUser.getUserById(id);
    }

    // @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/deleteUser/{id}")
    public Integer deleteUser(@PathVariable int id) {
        this.servUser.deleteUser(id);
        return id;
    }
}
