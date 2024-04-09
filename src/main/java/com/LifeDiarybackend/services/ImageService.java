package com.LifeDiarybackend.services;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.Image;
import com.LifeDiarybackend.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    public Image findImageByImageID(Long imageID) {
       return repository.findImageById(imageID);
    }

    public boolean addNewImage(Collection collection, Image image) {
        try {
            collection.addImage(image);
            repository.save(image);
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
