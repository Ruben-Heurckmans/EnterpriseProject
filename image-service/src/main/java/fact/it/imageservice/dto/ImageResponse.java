package fact.it.imageservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    private String id;
    private String imageCode;
    private String restaurantCode;
    private String reviewCode;
    private String imageUrl;
}
