package com.LifeDiarybackend.controllers;
import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.services.CollectionService;
import com.LifeDiarybackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class CollectionController {

    @Autowired
    private CollectionService service;

    @Autowired
    private UserService userService;

    @PostMapping("/api/collections/add")
    public ResponseEntity<Boolean> addCollection(@RequestBody String name) {
        User testUser = new User("test123", "test123");
        userService.addUser(testUser);
        Collection collectionToBeAdded = new Collection(testUser, name);
        if(service.addCollection(collectionToBeAdded).equalsIgnoreCase("Collection added")) {
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/api/collections/getCollections")
    public ResponseEntity<Iterable<Collection>> getCollections() {
        return new ResponseEntity<Iterable<Collection>>(service.readCollections(), HttpStatus.ACCEPTED);
    }

}
