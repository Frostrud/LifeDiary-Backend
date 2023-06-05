package com.LifeDiarybackend.services;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.repositories.CollectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<Collection> readCollections() {
        return repository.findAll();
    }
}
