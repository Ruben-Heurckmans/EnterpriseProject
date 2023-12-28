package fact.it.restaurantservice.controller;

import fact.it.restaurantservice.dto.RestaurantRequest;
import fact.it.restaurantservice.dto.RestaurantResponse;
import fact.it.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    /*
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        boolean result = restaurantService.addRestaurant(restaurantRequest);
        return (result ? "Restaurant succesvol aangemaakt" : "Restaurant aanmaken gefaald");
    }
    */

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantResponse> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{restaurantCode}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponse getRestaurantByRestaurantCode(@PathVariable String restaurantCode){
        return restaurantService.getRestaurantByRestaurantCode(restaurantCode);
    }
}
