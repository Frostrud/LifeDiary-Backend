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
    public ResponseEntity<String> doLogin(@RequestBody User user) {
        for(User userFound : userService.readUsers()) {
            if(userFound.getEmail().equalsIgnoreCase(user.getEmail())) {
                return new ResponseEntity<String>("User successfully logged in", HttpStatus.OK);
            }

        }

        return new ResponseEntity<String>("Email or password is wrong", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/api/signup")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User userToBeAdded = new User(user.getFirstName(), user.getLastName(), user.getMembership(),user.getEmail(), user.getPassword());
            if(!userService.existsUserByEmail(user.getEmail())) {
                userService.addUser(userToBeAdded);
                return new ResponseEntity<String>("User successfully added", HttpStatus.OK);
            }

        return new ResponseEntity<String>("Email is already in use", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/api/getUsers")
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<Iterable<User>>(userService.readUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/getID")
    public ResponseEntity<Integer> getId(@RequestBody String email) {
        System.out.println(email);
        return new ResponseEntity<Integer>(Math.toIntExact(userService.findUserByEmail(email).getUserId()), HttpStatus.OK);
    }
}
