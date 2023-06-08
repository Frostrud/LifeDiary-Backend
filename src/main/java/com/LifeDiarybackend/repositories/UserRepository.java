package com.LifeDiarybackend.repositories;

import com.LifeDiarybackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
        boolean existsByEmail(String email);

        User findByEmail(String email);

        boolean existsUserByEmail(String email);

        User findByUserId(long userID);
}

