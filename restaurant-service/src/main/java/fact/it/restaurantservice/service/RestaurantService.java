package fact.it.restaurantservice.service;


import fact.it.restaurantservice.dto.RestaurantRequest;
import fact.it.restaurantservice.dto.RestaurantResponse;
import fact.it.restaurantservice.model.Restaurant;
import fact.it.restaurantservice.repository.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


    @PostConstruct
    public void loadData(){
        if(restaurantRepository.count() == 0){
            Restaurant restaurant1 = new Restaurant();
            restaurant1.setRestaurantCode("Resto1");
            restaurant1.setName("De Verandering");
            restaurant1.setStreet("Achterbos");
            restaurant1.setStreetNumber("x");
            restaurant1.setPlace("Mol");
            restaurant1.setZipcode("2400");

            restaurantRepository.save(restaurant1);

            Restaurant restaurant2 = new Restaurant();
            restaurant1.setRestaurantCode("Resto2");
            restaurant1.setName("Restaurant2");
            restaurant1.setStreet("Straat2");
            restaurant1.setStreetNumber("2");
            restaurant1.setPlace("Plaats2");
            restaurant1.setZipcode("2000");

            restaurantRepository.save(restaurant2);
        }
    }

    /*
    private final WebClient webClient;

    public RestaurantService(WebClient webClient) {
        this.webClient = webClient;
        restaurantRepository = null;
    }
    */


    @Transactional()
    public List<RestaurantResponse> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(this::mapToRestaurantResponse).toList();
    }

    @Transactional()
    public RestaurantResponse getRestaurantByRestaurantCode(String restaurantCode){
        Restaurant restaurant = restaurantRepository.findByRestaurantCodeIn(Collections.singleton(restaurantCode));
        return mapToRestaurantResponse(restaurant);
    }

    public void createRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = Restaurant.builder()
                .restaurantCode(restaurantRequest.getRestaurantCode())
                .name(restaurantRequest.getName())
                .street(restaurantRequest.getStreet())
                .streetNumber(restaurantRequest.getStreetNumber())
                .place(restaurantRequest.getPlace())
                .zipcode(restaurantRequest.getZipcode())
                .build();

        restaurantRepository.save(restaurant);
    }

    private RestaurantResponse mapToRestaurantResponse(Restaurant restaurant){
        return RestaurantResponse.builder()
                .restaurantCode(restaurant.getRestaurantCode())
                .name(restaurant.getName())
                .street(restaurant.getStreet())
                .streetNumber(restaurant.getStreetNumber())
                .place(restaurant.getPlace())
                .zipcode(restaurant.getZipcode())
                .build();
    }

    public RestaurantResponse changeRestaurant(Restaurant updateRestaurant, String restaurantCode) {
        Restaurant restaurant = restaurantRepository.findByRestaurantCodeIn(Collections.singleton(restaurantCode));
        Optional<Restaurant> optionalRestaurant = null;
        if (restaurant != null){
            Long id = restaurant.getId();
            optionalRestaurant = restaurantRepository.findById(id);
            if (optionalRestaurant.isPresent()) {
                Restaurant oldRestaurant = optionalRestaurant.get();
                oldRestaurant.setRestaurantCode(updateRestaurant.getRestaurantCode());
                oldRestaurant.setName(updateRestaurant.getName());
                oldRestaurant.setStreet(updateRestaurant.getStreet());
                oldRestaurant.setStreetNumber(updateRestaurant.getStreetNumber());
                oldRestaurant.setPlace(updateRestaurant.getPlace());
                oldRestaurant.setZipcode(updateRestaurant.getZipcode());
                restaurantRepository.save(oldRestaurant);
                return mapToRestaurantResponse(oldRestaurant);
            }
        }

        return null;
    }
}
