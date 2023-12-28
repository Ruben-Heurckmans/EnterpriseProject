package fact.it.reviewservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "review")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Review {
    private String id;
    private String reviewCode;
    private String restaurantCode;
    private String userCode;
    private String description;
}
