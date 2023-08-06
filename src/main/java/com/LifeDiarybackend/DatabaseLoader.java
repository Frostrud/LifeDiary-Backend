package com.LifeDiarybackend;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.Text;
import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.repositories.CollectionRepository;
import com.LifeDiarybackend.repositories.TextRepository;
import com.LifeDiarybackend.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private final UserRepository userRepository;
    private final CollectionRepository collectionRepository;
    private final TextRepository textRepository;



    @Autowired
    public DatabaseLoader(UserRepository userRepository, CollectionRepository collectionRepository, TextRepository textRepository) {
        this.userRepository = userRepository;
        this.collectionRepository = collectionRepository;
        this.textRepository = textRepository;
    }

    @PostConstruct
    private void loadData() {
        User user = new User("Mr","Admin","Premium+","admin@test.com", "admin123");
        userRepository.save(user);
        Collection collection1 = new Collection(user, "Test Collection 1");
        collectionRepository.save(collection1);

        Collection collection2 = new Collection(user, "Test Collection 2");

        collectionRepository.save(collection2);

        Text text1 = new Text(collection1, "Basic headline", "basic content stuff etc etc");

        collection1.addText(text1);
        
        collectionRepository.save(collection1);
    }
}
