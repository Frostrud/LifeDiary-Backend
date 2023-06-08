package com.LifeDiarybackend.services;

import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public boolean addUser(User user) {
        try {
            if(!repository.existsByEmail(user.getEmail())) {
                repository.save(user);
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<User> readUsers() {
        return repository.findAll();
    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public boolean existsUserByEmail(String email) {
        return repository.existsUserByEmail(email);
    }

    public User findUserByUserId(long id) {
        return repository.findByUserId(id);
    }
}
