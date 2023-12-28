package fact.it.restaurantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponse {
    private String restaurantCode;
    private String name;
    private String street;
    private String streetNumber;
    private String zipcode;
    private String place;
}
