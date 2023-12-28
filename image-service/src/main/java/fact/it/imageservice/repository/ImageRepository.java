package fact.it.imageservice.repository;

import fact.it.imageservice.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public interface ImageRepository extends MongoRepository<Image, String> {
    Image findByImageCodeIn(Collection<String> imageCode);
}
