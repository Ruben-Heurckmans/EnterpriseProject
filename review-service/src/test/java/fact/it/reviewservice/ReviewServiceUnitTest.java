package fact.it.reviewservice;

import fact.it.reviewservice.dto.ReviewResponse;
import fact.it.reviewservice.model.Review;
import fact.it.reviewservice.repository.ReviewRepository;
import fact.it.reviewservice.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceUnitTest {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @Test
    public void testGetAllReviews() {
        // Arrange
        Review review = new Review();
        review.setId("1");
        review.setReviewCode("rev1");
        review.setDescription("TestReview");
        review.setUserCode("user1");
        review.setRestaurantCode("resto1");

        when(reviewRepository.findAll()).thenReturn(Arrays.asList(review));

        // Act
        List<ReviewResponse> reviews = reviewService.getAllReviews();

        // Assert
        assertEquals(1, reviews.size());
        assertEquals("rev1", reviews.get(0).getReviewCode());
        assertEquals("TestReview", reviews.get(0).getDescription());
        assertEquals("user1", reviews.get(0).getUserCode());
        assertEquals("resto1", reviews.get(0).getRestaurantCode());

        verify(reviewRepository, times(1)).findAll();
    }

    @Test
    public void testGetReviewByReviewCode() {
        // Arrange
        Review review = new Review();
        review.setId("1");
        review.setReviewCode("rev1");
        review.setDescription("TestReview");
        review.setUserCode("user1");
        review.setRestaurantCode("resto1");

        when(reviewRepository.findByReviewCodeIn(Collections.singleton("rev1"))).thenReturn(review);

        // Act
        ReviewResponse review1 = reviewService.getReviewByReviewCode("rev1");

        // Assert
        assertEquals("rev1", review1.getReviewCode());
        assertEquals("TestReview", review1.getDescription());
        assertEquals("user1", review1.getUserCode());
        assertEquals("resto1", review1.getRestaurantCode());

        verify(reviewRepository, times(1)).findByReviewCodeIn(Collections.singleton(review.getReviewCode()));
    }
}