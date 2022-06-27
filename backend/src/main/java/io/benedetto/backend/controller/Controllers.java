package io.benedetto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import io.benedetto.backend.model.Category;
import io.benedetto.backend.model.Product;
import io.benedetto.backend.model.User;

import io.benedetto.backend.service.ServCategory;
import io.benedetto.backend.service.ServProduct;
import io.benedetto.backend.service.ServUser;

@Controller
public class Controllers {
    @Autowired
    ServProduct servProduct;
    
    @Autowired
    ServCategory servCategory;

    @Autowired
    ServUser servUser;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/register") 
    public String register() {
        return "register";
    }

    @GetMapping("/category") 
    public String category() {
        return "category";
    }

    // Producto //
    @RequestMapping(value = "/product/createProduct", method = RequestMethod.POST)
    public void createProduct(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "description") String description,
        @RequestParam(name = "price") double price,
        @RequestParam(name = "quantity") int quantity,
        @RequestParam(name = "image") String image,
        @RequestParam(name = "category") int category
    ) {
        Product product = new Product(name, description, price, quantity, image, servCategory.getCategoryById(category));
        servProduct.createProduct(product);
    }

    @RequestMapping(value = "/product/getProductById", method = RequestMethod.GET)
    public Product getProductById(@RequestParam(name = "id") int id) {
        return servProduct.getProductById(id);
    }

    @RequestMapping(value = "/product/getAllProducts", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return servProduct.getAllProducts();
    }

    @RequestMapping(value = "/product/updateProduct/{id}", method = RequestMethod.PUT)
    public void updateProduct(
        @PathVariable int id,
        @RequestParam(name = "name") String name,
        @RequestParam(name = "description") String description,
        @RequestParam(name = "price") double price,
        @RequestParam(name = "quantity") int quantity,
        @RequestParam(name = "image") String image,
        @RequestParam(name = "category") int category
    ) {
        Product product = new Product(name, description, price, quantity, image, servCategory.getCategoryById(category));
        servProduct.updateProduct(id, product);
    }

    @RequestMapping(value = "/product/deleteProduct/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int id) {
        servProduct.deleteProduct(id);
    }

    // @PostMapping("/product/createProduct")
    // public void createProduct(@RequestBody Product product) {
    //     servProduct.createProduct(product);
    // }

    // @PutMapping("/product/updateProduct")
    // public void updateProduct(@RequestBody Product product) {
    //     Product oldProduct = servProduct.getProductById(product.getId());
    //     oldProduct.setName(product.getName());
    //     oldProduct.setDescription(product.getDescription());
    //     oldProduct.setPrice(product.getPrice());
    //     oldProduct.setQuantity(product.getQuantity());
    //     oldProduct.setImage(product.getImage());
    //     oldProduct.setCategory(product.getCategory());
    //     servProduct.createProduct(oldProduct);
    // }

    // @GetMapping("/product/getAllProducts")
    // public List<Product> getAllProducts() {
    //     return servProduct.getAllProducts();
    // }
    
    // @GetMapping("/product/getProductById/{id}")
    // public Product getProductById(@PathVariable int id) {
    //     return servProduct.getProductById(id);
    // }

    // @GetMapping("/product/deleteProduct/{id}")
    // public void deleteProduct(@PathVariable int id) {
    //     servProduct.deleteProduct(id);
    // }

    // Categoria //
    @RequestMapping(value = "/category/createCategory", method = RequestMethod.POST)
    public void createCategory(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "description") String description
    ) {
        Category category = new Category(name, description);
        servCategory.createCategory(category);
    }

    @RequestMapping(value = "/category/getCategory", method = RequestMethod.GET)
    public Category getCategoryById(@RequestParam(name = "id") int id) {
        return servCategory.getCategoryById(id);
    }

    @RequestMapping(value = "/category/getAllCategories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return servCategory.getAllCategories();
    }

    @RequestMapping(value = "/category/updateCategory/{id}", method = RequestMethod.PUT)
    public void updateCategory(
        @PathVariable int id,
        @RequestParam(name = "name") String name,
        @RequestParam(name = "description") String description
    ) {
        Category category = new Category(name, description);
        servCategory.updateCategory(id, category);
    }

    @RequestMapping(value = "/category/deleteCategory/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable int id) {
        servCategory.deleteCategory(id);
    }

    // @PostMapping("/category/createCategory")
    // public void createCategory(@RequestBody Category category) {
    //     this.servCategory.createCategory(category);
    // }

    // @PutMapping("/category/updateCategory/{id}")
    // public List<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
    //     Category oldCategory = servCategory.getCategoryById(id);
    //     oldCategory.setName(category.getName());
    //     oldCategory.setDescription(category.getDescription());
    //     servCategory.createCategory(oldCategory);
    //     return this.servCategory.getAllCategories();
    // }

    // @GetMapping("/category/getAllCategories")
    // public List<Category> getAllCategories() {
    //     return this.servCategory.getAllCategories();
    // }

    // @GetMapping("/category/getCategoryById/{id}")
    // public Category getCategoryById(@PathVariable int id) {
    //     return this.servCategory.getCategoryById(id);
    // }

    // @GetMapping("/category/deleteCategory/{id}")
    // public Integer deleteCategory(@PathVariable int id) {
    //     this.servCategory.deleteCategory(id);
    //     return id;
    // }

    // Usuario //
    // @CrossOrigin(origins = "http://localhost:3000/register")
    @RequestMapping(value = "/user/createUser", method = RequestMethod.POST)
    public String createUser(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "last_name") String last_name,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password
    ) {
        User user = new User(name, last_name, email, password);
        servUser.createUser(user);
        return "login";
    }

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    public User getUserById(@RequestParam(name = "id") int id) {
        return servUser.getUserById(id);
    }

    @RequestMapping(value = "/user/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return servUser.getAllUsers();
    }

    @RequestMapping(value = "/user/updateUser/{id}", method = RequestMethod.PUT)
    public void updateUser(
        @PathVariable int id,
        @RequestParam(name = "name") String name,
        @RequestParam(name = "last_name") String last_name,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "password") String password
    ) {
        User user = new User(name, last_name, email, password);
        servUser.updateUser(id, user);
    }

    @RequestMapping(value = "/user/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        servUser.deleteUser(id);
    }

    // @PostMapping("/user/createUser")
    // public void createUser(@RequestBody User user) {
    //     this.servUser.createUser(user);   
    // }

    // @PutMapping("/user/updateUser/{id}")
    // public void updateUser(@PathVariable int id, @RequestBody User user) {
    //     User oldUser = servUser.getUserById(id);
    //     oldUser.setName(user.getName());
    //     oldUser.setLast_name(user.getLast_name());
    //     oldUser.setEmail(user.getEmail());
    //     oldUser.setPassword(user.getPassword());
    //     servUser.createUser(oldUser);
    // }

    // @GetMapping("/user/getAllUsers")
    // public List<User> getAllUsers() {
    //     return this.servUser.getAllUsers();
    // }

    // @GetMapping("/user/getUserById/{id}")
    // public User getUserById(@PathVariable int id) {
    //     return this.servUser.getUserById(id);
    // }

    // @GetMapping("/user/deleteUser/{id}")
    // public Integer deleteUser(@PathVariable int id) {
    //     this.servUser.deleteUser(id);
    //     return id;
    // }
}
