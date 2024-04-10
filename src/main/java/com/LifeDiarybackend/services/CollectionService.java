package com.LifeDiarybackend.services;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.repositories.CollectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository repository;

    @Transactional
    public String addCollection(Collection collection) {
        try {
                repository.save(collection);
                return "Collection added";
        } catch (Exception e) {
            System.out.println("Error, collection not added");
        }
        return "Error, collection not added";
    }

    public Iterable<Collection> getUserCollections(long userID) {
        Iterable<Collection> returnList = repository.findAll();

        return StreamSupport.stream(returnList.spliterator(), false)
                .filter(collection -> collection.getUser().getUserId() == userID)
                .collect(Collectors.toList());
    }

    public Iterable<Collection> readCollections() {
        return repository.findAll();
    }

    public Collection findCollectionByUser(User user) {
        return repository.findCollectionByUser(user);
    }

    @Transactional
    public Collection findCollectionById(long Id) {
       return repository.findCollectionById(Id);
    }

    @Transactional
    public boolean deleteCollectionById(long Id) {
        try {
            repository.deleteById(Id);
            return true;
        } catch(Exception e) {
            System.out.println("Error, collection with ID " + Id + " failed to delete");
        }
        return false;
    }

    @Transactional
    public boolean editCollectionById(long Id, String name) {
        Collection collectionToBeEdited = findCollectionById(Id);
        collectionToBeEdited.setCollectionName(name);
        if(collectionToBeEdited.getCollectionName().equalsIgnoreCase(name)) {
            repository.save(collectionToBeEdited);
            return true;
        }
        return false;
    }

    public void saveCollection(Collection collection) {
        repository.save(collection);
    }
}
