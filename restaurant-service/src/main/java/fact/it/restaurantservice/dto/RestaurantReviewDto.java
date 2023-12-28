package fact.it.restaurantservice.dto;

import fact.it.restaurantservice.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReviewDto {
    private Long id;
    private Restaurant restaurant;
}
