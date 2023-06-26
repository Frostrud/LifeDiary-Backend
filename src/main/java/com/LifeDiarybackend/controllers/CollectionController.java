package com.LifeDiarybackend.controllers;
import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.CollectionRequest;
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
    public ResponseEntity<Boolean> addCollection(@RequestBody CollectionRequest request) {
        Collection collectionToBeAdded = new Collection(userService.findUserByUserId(request.id()), request.name());
        if(service.addCollection(collectionToBeAdded).equalsIgnoreCase("Collection added")) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/api/collections/getCollections")
    public ResponseEntity<Iterable<Collection>> getCollections() {
        return new ResponseEntity<Iterable<Collection>>(service.readCollections(), HttpStatus.OK);
    }

    @GetMapping("/api/collections/getCollectionsByUser={userID}")
    public ResponseEntity<Iterable<Collection>> getCollectionsByUserID(@PathVariable long userID) {
        return new ResponseEntity<Iterable<Collection>>(service.getUserCollections(userID), HttpStatus.OK);
    }

    @GetMapping("/api/collections/getSingleCollectionByCollectionID={collectionId}")
    public ResponseEntity<Collection> getCollectionByCollectionId(@PathVariable long collectionId) {
        return new ResponseEntity<Collection>(service.findCollectionById(collectionId), HttpStatus.OK);
    }
}
