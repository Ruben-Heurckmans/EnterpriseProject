package fact.it.restaurantservice.dto;

import fact.it.restaurantservice.model.RestaurantReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private String street;
    private String streetNumber;
    private String zipcode;
    private String place;
    private List<RestaurantReview> reviewList;
}
