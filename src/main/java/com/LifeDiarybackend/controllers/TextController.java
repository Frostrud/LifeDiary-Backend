package com.LifeDiarybackend.controllers;

import com.LifeDiarybackend.models.Text;
import com.LifeDiarybackend.models.TextRequest;
import com.LifeDiarybackend.services.CollectionService;
import com.LifeDiarybackend.services.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class TextController {

  @Autowired
  private TextService service;
  @Autowired
  private CollectionService collectionService;


  @GetMapping("/api/texts/getSingleTextByTextID={textID}")
  public ResponseEntity<Text> getTextByTextID(@PathVariable long textID) {
    return new ResponseEntity<Text>(service.findTextByTextID(textID), HttpStatus.OK);
  }

  @PostMapping("/api/texts/add")
  public ResponseEntity<Boolean> addNewText(@RequestBody TextRequest request) {
    if(service.addNewText(collectionService.findCollectionById(request.id()), request.contentOrHeadline())) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
  }

  @PutMapping("/api/texts/update")
  public ResponseEntity<Boolean> updateText(@RequestBody TextRequest request) {
    if(service.updateTextContent(request.id(), request.contentOrHeadline())) {
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
  }
}
