package com.LifeDiarybackend.controllers;

import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public ResponseEntity<Boolean> doLogin(@RequestBody User user) {
        for(User userFound : userService.readUsers()) {
            if(userFound.getUsername().equalsIgnoreCase(user.getUsername())) {
                return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
            }

        }

        return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/api/create")
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        for(User userFound : userService.readUsers()) {
            if(!userFound.getUsername().equalsIgnoreCase(user.getUsername())) {
                userService.addUser(new User(user.getUsername(), user.getPassword()));
                return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
            }

        }

        return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
    }
}
