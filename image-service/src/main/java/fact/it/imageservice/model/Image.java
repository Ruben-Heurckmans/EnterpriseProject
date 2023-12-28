package fact.it.imageservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "image")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Image {
    private String id;
    private String imageCode;
    private String restaurantCode;
    private String reviewCode;
    private String imageUrl;
}
