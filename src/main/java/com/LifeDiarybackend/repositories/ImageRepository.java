package com.LifeDiarybackend.repositories;

import com.LifeDiarybackend.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, String> {

    Image findImageById(Long imageID);
}
