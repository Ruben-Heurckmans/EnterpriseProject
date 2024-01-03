package fact.it.restaurantservice;

import fact.it.restaurantservice.dto.RestaurantResponse;
import fact.it.restaurantservice.dto.RestaurantRequest;
import fact.it.restaurantservice.model.Restaurant;
import fact.it.restaurantservice.repository.RestaurantRepository;
import fact.it.restaurantservice.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceUnitTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Test
    public void testCreateRestaurant() {
        // Arrange
        RestaurantRequest restaurantRequest = new RestaurantRequest();
        restaurantRequest.setName("TestRestaurant");
        restaurantRequest.setRestaurantCode("resto1");
        restaurantRequest.setStreet("Achterbos");
        restaurantRequest.setStreetNumber("1");
        restaurantRequest.setPlace("Mol");
        restaurantRequest.setZipcode("2400");

        // Act
        restaurantService.createRestaurant(restaurantRequest);

        // Assert
        verify(restaurantRepository, times(1)).save(any(Restaurant.class));
    }

    @Test
    public void testChangeRestaurant() {
        // Arrange
        Restaurant updateRestaurant = new Restaurant();
        updateRestaurant.setRestaurantCode("resto2");
        updateRestaurant.setName("TestRestaurant2");
        updateRestaurant.setStreet("Achterbos2");
        updateRestaurant.setStreetNumber("2");
        updateRestaurant.setPlace("Mol2");
        updateRestaurant.setZipcode("24002");

        Restaurant existingRestaurant = new Restaurant();
        existingRestaurant.setId(8743921856723412L);
        existingRestaurant.setRestaurantCode("resto1");
        existingRestaurant.setName("TestRestaurant");
        existingRestaurant.setStreet("Achterbos");
        existingRestaurant.setStreetNumber("1");
        existingRestaurant.setPlace("Mol");
        existingRestaurant.setZipcode("2400");

        when(restaurantRepository.findByRestaurantCodeIn(Collections.singleton("resto1"))).thenReturn(existingRestaurant);
        when(restaurantRepository.findById(existingRestaurant.getId())).thenReturn(Optional.of(existingRestaurant));

        // Act
        RestaurantResponse updatedResponse = restaurantService.changeRestaurant(updateRestaurant, "resto1");

        // Assert
        assertEquals("resto2", updatedResponse.getRestaurantCode());
        assertEquals("TestRestaurant2", updatedResponse.getName());
        assertEquals("Achterbos2", updatedResponse.getStreet());
        assertEquals("2", updatedResponse.getStreetNumber());
        assertEquals("Mol2", updatedResponse.getPlace());
        assertEquals("24002", updatedResponse.getZipcode());

        verify(restaurantRepository, times(1)).findByRestaurantCodeIn(Collections.singleton("resto1"));
        verify(restaurantRepository, times(1)).findById(existingRestaurant.getId());
        verify(restaurantRepository, times(1)).save(existingRestaurant);
    }

    @Test
    public void testGetAllRestaurants() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        restaurant.setId(8743921856723412L);
        restaurant.setRestaurantCode("resto1");
        restaurant.setName("TestRestaurant");
        restaurant.setStreet("Achterbos");
        restaurant.setStreetNumber("1");
        restaurant.setPlace("Mol");
        restaurant.setZipcode("2400");

        when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));

        // Act
        List<RestaurantResponse> restaurants = restaurantService.getAllRestaurants();

        // Assert
        assertEquals(1, restaurants.size());
        assertEquals("resto1", restaurants.get(0).getRestaurantCode());
        assertEquals("TestRestaurant", restaurants.get(0).getName());
        assertEquals("Achterbos", restaurants.get(0).getStreet());
        assertEquals("1", restaurants.get(0).getStreetNumber());
        assertEquals("Mol", restaurants.get(0).getPlace());
        assertEquals("2400", restaurants.get(0).getZipcode());

        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    public void testGetRestaurantByRestaurantCode() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        restaurant.setId(8743921856723412L);
        restaurant.setRestaurantCode("resto1");
        restaurant.setName("TestRestaurant");
        restaurant.setStreet("Achterbos");
        restaurant.setStreetNumber("1");
        restaurant.setPlace("Mol");
        restaurant.setZipcode("2400");

        when(restaurantRepository.findByRestaurantCodeIn(Collections.singleton("resto1"))).thenReturn(restaurant);

        // Act
        RestaurantResponse restaurant1 = restaurantService.getRestaurantByRestaurantCode("resto1");

        // Assert
        assertEquals("resto1", restaurant1.getRestaurantCode());
        assertEquals("TestRestaurant", restaurant1.getName());
        assertEquals("Achterbos", restaurant1.getStreet());
        assertEquals("1", restaurant1.getStreetNumber());
        assertEquals("Mol", restaurant1.getPlace());
        assertEquals("2400", restaurant1.getZipcode());

        verify(restaurantRepository, times(1)).findByRestaurantCodeIn(Collections.singleton(restaurant.getRestaurantCode()));
    }
}