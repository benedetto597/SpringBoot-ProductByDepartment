package io.benedetto.springboottoheroku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import io.benedetto.springboottoheroku.model.Category;
import io.benedetto.springboottoheroku.repository.RepoCategory;

@Service
public class ServCategory {
    @Autowired
    RepoCategory repoCategory;

    public void createCategory(Category category) {
        repoCategory.save(category);
    }

    public List<Category> getAllCategories() {
        return repoCategory.findAll();
    }

    public Category getCategoryById(int id) {
        return repoCategory.findById(id);
    }

    public void deleteCategory(int id) {
        repoCategory.deleteById(id);
    }

    public void updateCategory(int id, Category category) {
        this.deleteCategory(id);
        repoCategory.save(category);
    }
    
}
