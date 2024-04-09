package com.LifeDiarybackend;

import com.LifeDiarybackend.models.Collection;
import com.LifeDiarybackend.models.Image;
import com.LifeDiarybackend.models.Text;
import com.LifeDiarybackend.models.User;
import com.LifeDiarybackend.repositories.CollectionRepository;
import com.LifeDiarybackend.repositories.ImageRepository;
import com.LifeDiarybackend.repositories.TextRepository;
import com.LifeDiarybackend.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DatabaseLoader {

    private final UserRepository userRepository;
    private final CollectionRepository collectionRepository;
    private final TextRepository textRepository;

    private final ImageRepository imageRepository;
    private final ResourceLoader resourceLoader;



    @Autowired
    public DatabaseLoader(UserRepository userRepository, CollectionRepository collectionRepository, TextRepository textRepository,
                          ImageRepository imageRepository, ResourceLoader resourceLoader) {
        this.userRepository = userRepository;
        this.collectionRepository = collectionRepository;
        this.textRepository = textRepository;
        this.imageRepository = imageRepository;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    private void loadData() throws IOException {
        User user = new User("Mr","Admin","Premium+","admin@test.com", "admin123");
        userRepository.save(user);
        Collection collection1 = new Collection(user, "Test Collection 1");
        collectionRepository.save(collection1);

        Text text1 = new Text(collection1, "The Ultimate Lorem Ipsum", "{\"blocks\":[{\"key\":\"eilag\",\"text\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Duis vel urna  ut tortor gravida aliquam a vel libero. Donec augue risus, facilisis non  sem a, molestie semper arcu. Curabitur porta vel velit vitae suscipit.  " +
                "Donec ut ipsum interdum, dignissim nisl vestibulum, semper orci. Nullam  elit est, blandit id urna et, consectetur viverra metus. Etiam molestie  dui augue, porttitor mollis " +
                "tortor convallis eu. Mauris vehicula quam  nisl, eu varius nibh volutpat vitae. Integer tristique auctor risus,  vitae viverra est rhoncus eget. Duis congue, lacus id molestie molestie,  " +
                "dui felis suscipit nisi, sit amet luctus enim augue vitae libero.\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[{\"offset\":0,\"length\":11,\"style\":\"UNDERLINE\"},{\"offset\":0,\"length" +
                "\":11,\"style\":\"BOLD\"}],\"entityRanges\":[],\"data\":{}},{\"key\":\"19rlo\",\"text\":\"\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}},{\"key\":" +
                "\"96r38\",\"text\":\"Maecenas ut mattis nisi, ornare dictum urna. Curabitur eu sapien vitae  nibh efficitur maximus. Maecenas eu porta ex, vel feugiat felis. Aliquam  erat volutpat. Pellentesque " +
                "rutrum tellus et mauris sollicitudin, sit  amet suscipit felis congue. Ut tristique vel libero ut pretium. Etiam mi  velit, sagittis ac rutrum in, luctus nec nulla. Orci varius natoque  penatibus " +
                "et magnis dis parturient montes, nascetur ridiculus mus. Donec  orci lorem, sodales nec tincidunt et, dictum sit amet lorem. Mauris  venenatis condimentum magna, non imperdiet elit semper eget. " +
                "Phasellus  tortor augue, molestie sed tempus bibendum, ultrices a sem. Nunc in  justo ligula. In ac varius purus, vitae egestas velit. Aliquam quis  mauris vel augue lobortis posuere vitae vel " +
                "lectus.\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}},{\"key\":\"76cc6\",\"text\":\"\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[]," +
                "\"entityRanges\":[],\"data\":{}},{\"key\":\"8j36k\",\"text\":\"Phasellus eu est ac augue luctus mattis sed quis dolor. Vivamus vitae  purus vitae neque mollis dapibus nec ac lacus. Donec tellus orci,  " +
                "iaculis in ullamcorper ut, imperdiet eu enim. Integer malesuada elit at  ex malesuada, in aliquam neque tristique. Fusce ut leo sed diam  vulputate tincidunt nec ut tortor. Duis viverra eget eros ac accumsan.  " +
                "Nulla ullamcorper fringilla libero, nec malesuada dui sollicitudin sed.  Cras sit amet sagittis risus. Fusce ut porta lorem. Pellentesque viverra  velit at est posuere pellentesque. Vestibulum efficitur lorem enim" +
                ", et  sagittis eros dignissim venenatis.\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}},{\"key\":\"eai50\",\"text\":\"\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[]," +
                "\"entityRanges\":[],\"data\":{}},{\"key\":\"5eume\",\"text\":\"Aliquam ornare ex ut turpis finibus, sed pulvinar augue feugiat. Nulla  massa mi, vestibulum id eros vitae, gravida pretium dui. Aliquam dapibus  tellus et " +
                "ligula consequat, et pulvinar turpis feugiat. Ut porta mattis  odio sed fermentum. Etiam aliquet nisi vel fermentum hendrerit. Sed  odio lorem, feugiat vel commodo vel, vehicula ut ligula. Cras vitae  vehicula elit, a " +
                "convallis magna. Nam placerat lacus vel erat lacinia  convallis. In placerat purus sed ipsum eleifend, ut mattis leo gravida.  Etiam vestibulum eros tortor, vel pretium tellus volutpat a. Praesent  dignissim sagittis nisl " +
                "vel placerat. Quisque egestas nisi elit, eu  semper orci venenatis vitae. Mauris tincidunt, eros egestas tempus  convallis, justo sapien bibendum leo, ac efficitur nisl neque vel  lectus. Fusce vitae accumsan urna. " +
                "Fusce mattis sapien gravida diam  consequat volutpat.\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}},{\"key\":\"2gksk\",\"text\":\"Pellentesque eu tellus eu nisl venenatis interdum." +
                " Maecenas tempus ante  in mi dictum, eu mattis augue tempus. Duis bibendum ex eget eros  placerat iaculis. Proin sodales mi quis commodo malesuada. Duis in lacus  odio. Class aptent taciti sociosqu ad litora torquent per conubia  nostra," +
                " per inceptos himenaeos. Duis viverra posuere lorem at auctor.  Proin tristique neque ac vestibulum dapibus. Maecenas metus sapien,  lacinia viverra iaculis ac, vulputate ut diam. Donec efficitur, lacus  vel dignissim laoreet, dolor lacus pharetra " +
                "justo, ac ullamcorper neque  est et justo. Fusce pharetra urna et nisl vulputate, sed dignissim diam  bibendum. In dolor neque, efficitur vitae mi vitae, mattis consequat  dui.\",\"type\":\"unstyled\",\"depth\":0,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}");

        collection1.addText(text1);
        
        collectionRepository.save(collection1);

        Resource imageResource = resourceLoader.getResource("classpath:static/kongen.jpg");
        byte[] imageBytes = Files.readAllBytes(Paths.get(imageResource.getURI()));
        Image testImage = new Image("Test Image", imageBytes, collection1);

        collection1.addImage(testImage);
        collectionRepository.save(collection1);
    }
}
