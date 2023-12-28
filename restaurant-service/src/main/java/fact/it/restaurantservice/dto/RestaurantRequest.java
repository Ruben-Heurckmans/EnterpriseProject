package fact.it.restaurantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
    private String restaurantCode;
    private String name;
    private String street;
    private String streetNumber;
    private String zipcode;
    private String place;
}
