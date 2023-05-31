package com.LifeDiarybackend.repositories;

import com.LifeDiarybackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
        boolean existsByUsername(String username);
}

