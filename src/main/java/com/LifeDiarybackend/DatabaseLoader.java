package com.LifeDiarybackend;

import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private final UserRepository userRepository;



    @Autowired
    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void loadData() {
        User user = new User("Mr","Admin","Premium+","admin@test.com", "admin123");
        userRepository.save(user);
    }
}
