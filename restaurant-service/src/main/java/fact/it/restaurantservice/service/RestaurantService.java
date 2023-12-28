package fact.it.restaurantservice.service;


import fact.it.restaurantservice.dto.RestaurantRequest;
import fact.it.restaurantservice.dto.RestaurantResponse;
import fact.it.restaurantservice.model.Restaurant;
import fact.it.restaurantservice.repository.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


    @PostConstruct
    public void loadData(){
        if(restaurantRepository.count() > 0){
            Restaurant restaurant1 = new Restaurant();
            restaurant1.setRestaurantCode("Resto1");
            restaurant1.setName("De Verandering");
            restaurant1.setStreet("Achterbos");
            restaurant1.setStreetNumber("x");
            restaurant1.setPlace("Mol");
            restaurant1.setZipcode("2400");

            restaurantRepository.save(restaurant1);
        }
    }

    /*
    private final WebClient webClient;

    public RestaurantService(WebClient webClient) {
        this.webClient = webClient;
        restaurantRepository = null;
    }
    */

    /*
    public boolean addRestaurant(RestaurantRequest restaurantRequest){
        Restaurant restaurant = new Restaurant();

        restaurantRepository.save(restaurant);
        return true;
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


    /*

    public List<OrderResponse> getAllReviews() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> new OrderResponse(
                        order.getOrderNumber(),
                        mapToOrderLineItemsDto(order.getOrderLineItemsList())
                ))
                .collect(Collectors.toList());
    }

     */

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
}
