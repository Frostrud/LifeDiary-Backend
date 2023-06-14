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
            throw e;
        }
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
}
