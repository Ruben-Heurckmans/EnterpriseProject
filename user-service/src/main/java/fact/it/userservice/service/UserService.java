package fact.it.userservice.service;

import fact.it.userservice.dto.UserResponse;
import fact.it.userservice.model.User;
import fact.it.userservice.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @PostConstruct
    public void loadData(){
        if(userRepository.count() == 0){
            User user1 = new User();
            user1.setUserCode("user1");
            user1.setName("Heurckmans");
            user1.setFirstName("Ruben");
            user1.setStreet("Zelm");
            user1.setStreetNumber("51");
            user1.setPlace("Mol");
            user1.setZipcode("2400");

            userRepository.save(user1);
        }
    }

    @Transactional()
    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();

        return users.stream().map(this::mapToUserResponse).toList();
    }

    @Transactional()
    public UserResponse getUserByUserCode(String userCode){
        User user = userRepository.findByUserCodeIn(Collections.singleton(userCode));

        return mapToUserResponse(user);
    }

    private UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .userCode(user.getUserCode())
                .name(user.getName())
                .firstName(user.getFirstName())
                .street(user.getStreet())
                .streetNumber(user.getStreetNumber())
                .place(user.getPlace())
                .zipcode(user.getZipcode())
                .build();
    }
}
