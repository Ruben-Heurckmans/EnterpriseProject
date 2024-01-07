package fact.it.reviewservice.service;

import fact.it.reviewservice.dto.ReviewRequest;
import fact.it.reviewservice.dto.ReviewResponse;
import fact.it.reviewservice.model.Review;
import fact.it.reviewservice.repository.ReviewRepository;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @PostConstruct
    public void loadData(){
        if(reviewRepository.count() == 0){
            Review review1 = new Review();
            review1.setReviewCode("rev1");
            review1.setRestaurantCode("resto1");
            review1.setUserCode("user1");
            review1.setDescription("Goed restaurant");

            reviewRepository.save(review1);

            Review review2 = new Review();
            review1.setReviewCode("rev2");
            review1.setRestaurantCode("resto2");
            review1.setUserCode("user2");
            review1.setDescription("Meh restaurant");

            reviewRepository.save(review2);
        }
    }

    @Transactional()
    public List<ReviewResponse> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::mapToReviewResponse).toList();
    }

    @Transactional()
    public ReviewResponse getReviewByReviewCode(String reviewCode){
        Review review = reviewRepository.findByReviewCodeIn(Collections.singleton(reviewCode));
        return mapToReviewResponse(review);
    }

    @Transactional()
    public String deleteReviewByReviewCode(String reviewCode){
        Review review = reviewRepository.findByReviewCodeIn(Collections.singleton(reviewCode));

        reviewRepository.deleteById(review.getId());
        return "Review deleted";
    }

    private ReviewResponse mapToReviewResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .reviewCode(review.getReviewCode())
                .restaurantCode(review.getRestaurantCode())
                .userCode(review.getUserCode())
                .description(review.getDescription())
                .build();
    }
}
