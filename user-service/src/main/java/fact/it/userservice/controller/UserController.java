package fact.it.userservice.controller;

import fact.it.userservice.dto.UserResponse;
import fact.it.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/{userCode}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserByUserCode(@PathVariable String userCode){
        return userService.getUserByUserCode(userCode);
    }
}
