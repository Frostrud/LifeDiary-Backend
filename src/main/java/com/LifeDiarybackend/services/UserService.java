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
    public String addUser(User user) {
        try {
            if(!repository.existsByUsername(user.getUsername())) {
                repository.save(user);
                return "User Created";

            } else {
                return "User already exists";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<User> readUsers() {
        return repository.findAll();
    }
}
