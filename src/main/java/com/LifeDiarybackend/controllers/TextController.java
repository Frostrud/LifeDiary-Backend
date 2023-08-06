package com.LifeDiarybackend.controllers;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.Text;
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


  @GetMapping("/api/texts/getSingleTextByTextID={textID}")
  public ResponseEntity<Text> getCollectionByCollectionId(@PathVariable long textID) {
    return new ResponseEntity<Text>(service.findTextByTextID(textID), HttpStatus.OK);
  }
}
