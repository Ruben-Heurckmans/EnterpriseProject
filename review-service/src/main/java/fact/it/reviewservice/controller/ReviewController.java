package fact.it.reviewservice.controller;

import fact.it.reviewservice.dto.ReviewRequest;
import fact.it.reviewservice.dto.ReviewResponse;
import fact.it.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/get/{reviewCode}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse getReviewByReviewCode(@PathVariable String reviewCode){
        return reviewService.getReviewByReviewCode(reviewCode);
    }

    @DeleteMapping ("/delete/{reviewCode}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteReviewByReviewCode(@PathVariable String reviewCode){
        return reviewService.deleteReviewByReviewCode(reviewCode);
    }
}
