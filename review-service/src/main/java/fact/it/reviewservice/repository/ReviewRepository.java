package fact.it.reviewservice.repository;

import fact.it.reviewservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface ReviewRepository extends MongoRepository<Review, String> {
    Review findByReviewCodeIn(Collection<String> reviewCode);
}
