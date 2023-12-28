package fact.it.restaurantservice.dto;

import fact.it.restaurantservice.model.Image;
import fact.it.restaurantservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private String id;
    private User user;
    private List<Image> imageList;
}
