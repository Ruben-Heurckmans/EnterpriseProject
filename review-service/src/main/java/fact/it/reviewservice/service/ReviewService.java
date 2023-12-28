package fact.it.reviewservice.service;

import fact.it.reviewservice.dto.ReviewRequest;
import fact.it.reviewservice.dto.ReviewResponse;
import fact.it.reviewservice.model.Review;
import fact.it.reviewservice.repository.ReviewRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void createReview(ReviewRequest reviewRequest){
        Review review = Review.builder()
                .user(reviewRequest.getUser())
                .restaurant(reviewRequest.getRestaurant())
                .imageList(reviewRequest.getImageList())
                .build();

        reviewRepository.save(review);
    }

    public List<ReviewResponse> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();

        return reviews.stream().map(this::mapToReviewResponse).toList();
    }

    private ReviewResponse mapToReviewResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .user(review.getUser())
                .restaurant(review.getRestaurant())
                .imageList(review.getImageList())
                .build();
    }
}
