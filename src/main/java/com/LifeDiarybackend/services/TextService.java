package com.LifeDiarybackend.services;

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
}
