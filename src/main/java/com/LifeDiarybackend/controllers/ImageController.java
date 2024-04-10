package com.LifeDiarybackend.controllers;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.Image;
import com.LifeDiarybackend.repositories.CollectionRepository;
import com.LifeDiarybackend.repositories.ImageRepository;
import com.LifeDiarybackend.services.CollectionService;
import com.LifeDiarybackend.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ImageController {

    @Autowired
    private ImageService service;

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/api/images/getSingleImageByID={imageID}")
    public ResponseEntity<Image> getImageByImageID(@PathVariable long imageID) {
        Image imageToBeReturned = service.findImageByImageID(imageID);
        imageToBeReturned.encodeDataToBase64();

        return new ResponseEntity<Image>(imageToBeReturned, HttpStatus.OK);
    }

    @PostMapping("/api/images/upload")
    public ResponseEntity<Boolean> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("collectionID") Long collectionID) throws IOException {
        try {
            Collection collection = collectionService.findCollectionById(collectionID);
            Image imageToBeSaved = new Image(file.getOriginalFilename(), file.getBytes(),
                    collection);
            service.addNewImage(collection, imageToBeSaved);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (IOException i) {
            System.out.println(i.getMessage());
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

    }

}
