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

import java.util.ArrayList;
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
            List<String> imageString = new ArrayList<>(List.of("img1"));
            review1.setImageCodes(imageString);

            reviewRepository.save(review1);

            Review review2 = new Review();
            review2.setReviewCode("rev2");
            review2.setRestaurantCode("resto2");
            review2.setUserCode("user2");
            review2.setDescription("Meh restaurant");
            List<String> imageString2 = new ArrayList<>(List.of("img2", "img3"));
            review2.setImageCodes(imageString2);
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
                .imageCodes(review.getImageCodes())
                .build();
    }


    public void createReview(ReviewRequest reviewRequest) {
        Review review = Review.builder()
                .reviewCode(reviewRequest.getReviewCode())
                .restaurantCode(reviewRequest.getRestaurantCode())
                .userCode(reviewRequest.getUserCode())
                .description(reviewRequest.getDescription())
                .imageCodes(reviewRequest.getImageCodes())
                .build();

        reviewRepository.save(review);
    }
}
