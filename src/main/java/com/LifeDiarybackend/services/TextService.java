package com.LifeDiarybackend.services;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.Text;
import com.LifeDiarybackend.repositories.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextService {

  @Autowired
  private TextRepository repository;

  public Text findTextByTextID(Long textID) {
    return repository.findTextById(textID);
  }

  public boolean addNewText(Collection collection, String textHeadline) {
   try {
        Text newText = new Text(collection, textHeadline, "");
        collection.addText(newText);
        repository.save(newText);
        return true;
   } catch(Exception e) {
       System.out.println(e.getMessage());
         return false;
    }
  }

  public boolean updateTextContent(Long textID, String newContent) {
      try {
        Text textToBeUpdated = repository.findTextById(textID);
        textToBeUpdated.setContent(newContent);
        repository.save(textToBeUpdated);
        return true;
      } catch(Exception e) {
          System.out.println(e.getMessage());
         return false;
      }
  }
}
