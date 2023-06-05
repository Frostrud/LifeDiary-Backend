package com.LifeDiarybackend.repositories;

import com.LifeDiarybackend.models.Collection;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, String> {

}
