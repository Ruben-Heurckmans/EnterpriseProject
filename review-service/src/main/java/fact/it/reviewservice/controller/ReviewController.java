package fact.it.reviewservice.controller;

import fact.it.reviewservice.dto.ReviewRequest;
import fact.it.reviewservice.dto.ReviewResponse;
import fact.it.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.createReview(reviewRequest);
    }
    */

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/{reviewCode}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse getReviewByReviewCode(@PathVariable String reviewCode){
        return reviewService.getReviewByReviewCode(reviewCode);
    }

    @DeleteMapping ("/{reviewCode}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteReviewByReviewCode(@PathVariable String reviewCode){
        return reviewService.deleteReviewByReviewCode(reviewCode);
    }
}
