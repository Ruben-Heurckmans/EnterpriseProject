package fact.it.restaurantservice.service;


import fact.it.restaurantservice.dto.RestaurantRequest;
import fact.it.restaurantservice.dto.RestaurantResponse;
import fact.it.restaurantservice.model.Restaurant;
import fact.it.restaurantservice.repository.RestaurantRepository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final WebClient webClient;

    public RestaurantService(WebClient webClient) {
        this.webClient = webClient;
        restaurantRepository = null;
    }


    public boolean addRestaurant(RestaurantRequest restaurantRequest){
        Restaurant restaurant = new Restaurant();

        restaurantRepository.save(restaurant);
        return true;
    }

    public List<RestaurantResponse> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants.stream()
                .map(restaurant -> new RestaurantResponse(
                ))
                .collect(Collectors.toList());
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
}
