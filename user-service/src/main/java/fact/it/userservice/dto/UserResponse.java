package fact.it.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String userCode;
    private String name;
    private String firstName;
    private String street;
    private String streetNumber;
    private String place;
    private String zipcode;
}
