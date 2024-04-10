package com.LifeDiarybackend.controllers;

import com.LifeDiarybackend.models.Image;
import com.LifeDiarybackend.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping("/api/images/getSingleImageByID={imageID}")
    public ResponseEntity<Image> getImageByImageID(@PathVariable long imageID) {
        Image imageToBeReturned = service.findImageByImageID(imageID);
        imageToBeReturned.encodeDataToBase64();

        return new ResponseEntity<Image>(imageToBeReturned, HttpStatus.OK);
    }

}
