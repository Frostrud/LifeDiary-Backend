package com.LifeDiarybackend.repositories;

import com.LifeDiarybackend.models.Text;
import org.springframework.data.repository.CrudRepository;

public interface TextRepository extends CrudRepository<Text, String> {

  Text findTextById(Long textID);
}
