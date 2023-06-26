package com.LifeDiarybackend.repositories;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, String> {
  Collection findCollectionByUser(User user);

  Iterable<Collection> findAll();

  Collection findCollectionById(long Id);
}
