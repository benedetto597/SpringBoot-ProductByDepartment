package io.benedetto.springboottoheroku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import io.benedetto.springboottoheroku.model.User;
import io.benedetto.springboottoheroku.repository.RepoUser;

@Service
public class ServUser {
    @Autowired
    RepoUser repoUser;

    public void createUser(User user) {
        repoUser.save(user);
    }

    public List<User> getAllUsers() {
        return repoUser.findAll();
    }

    public User getUserById(int id) {
        return repoUser.findById(id);
    }

    public void deleteUser(int id) {
        repoUser.deleteById(id);
    }

    public void updateUser(int id, User user) {
        this.deleteUser(id);
        repoUser.save(user);
    }
    
}
