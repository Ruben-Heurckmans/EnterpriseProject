package fact.it.reviewservice.dto;

import fact.it.reviewservice.model.Image;
import fact.it.reviewservice.model.Restaurant;
import fact.it.reviewservice.model.User;
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
    private String user;
    private String restaurant;
    private String imageList;
}
