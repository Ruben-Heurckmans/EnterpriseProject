package fact.it.reviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String reviewCode;
    private String restaurantCode;
    private String userCode;
    private String description;
    private List<String> imageCodes;

}
