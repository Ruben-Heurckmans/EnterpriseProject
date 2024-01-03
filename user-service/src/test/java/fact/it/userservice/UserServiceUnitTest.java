package fact.it.userservice;

import fact.it.userservice.dto.UserResponse;
import fact.it.userservice.model.User;
import fact.it.userservice.repository.UserRepository;
import fact.it.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetAllUsers() {
        // Arrange
        User user = new User();
        user.setId(8743921856723412L);
        user.setUserCode("user1");
        user.setName("TestUser");
        user.setStreet("Achterbos");
        user.setStreetNumber("1");
        user.setPlace("Mol");
        user.setZipcode("2400");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        // Act
        List<UserResponse> users = userService.getAllUsers();

        // Assert
        assertEquals(1, users.size());
        assertEquals("user1", users.get(0).getUserCode());
        assertEquals("TestUser", users.get(0).getName());
        assertEquals("Achterbos", users.get(0).getStreet());
        assertEquals("1", users.get(0).getStreetNumber());
        assertEquals("Mol", users.get(0).getPlace());
        assertEquals("2400", users.get(0).getZipcode());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserByUserCode() {
        // Arrange
        User user = new User();
        user.setId(8743921856723412L);
        user.setUserCode("user1");
        user.setName("TestUser");
        user.setStreet("Achterbos");
        user.setStreetNumber("1");
        user.setPlace("Mol");
        user.setZipcode("2400");

        when(userRepository.findByUserCodeIn(Collections.singleton("user1"))).thenReturn(user);

        // Act
        UserResponse user1 = userService.getUserByUserCode("user1");

        // Assert
        assertEquals("user1", user1.getUserCode());
        assertEquals("TestUser", user1.getName());
        assertEquals("Achterbos", user1.getStreet());
        assertEquals("1", user1.getStreetNumber());
        assertEquals("Mol", user1.getPlace());
        assertEquals("2400", user1.getZipcode());

        verify(userRepository, times(1)).findByUserCodeIn(Collections.singleton(user.getUserCode()));
    }
}