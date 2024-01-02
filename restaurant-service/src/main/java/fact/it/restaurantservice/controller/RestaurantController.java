package fact.it.restaurantservice.controller;

import fact.it.restaurantservice.dto.RestaurantRequest;
import fact.it.restaurantservice.dto.RestaurantResponse;
import fact.it.restaurantservice.model.Restaurant;
import fact.it.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantResponse> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/get/{restaurantCode}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponse getRestaurantByRestaurantCode(@PathVariable String restaurantCode){
        return restaurantService.getRestaurantByRestaurantCode(restaurantCode);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        restaurantService.createRestaurant(restaurantRequest);
    }

    @PutMapping("/update/{restaurantCode}")
    @ResponseStatus(HttpStatus.OK)
    public RestaurantResponse changeRestaurant(@RequestBody Restaurant updateRestaurant, @PathVariable String restaurantCode) {
        return restaurantService.changeRestaurant(updateRestaurant, restaurantCode);
    }
}
