package fact.it.imageservice.service;

import fact.it.imageservice.dto.ImageResponse;
import fact.it.imageservice.model.Image;
import fact.it.imageservice.repository.ImageRepository;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    @PostConstruct
    public void loadData(){
        if(imageRepository.count() == 0){
            Image image1 = new Image();
            image1.setImageCode("img1");
            image1.setRestaurantCode("resto1");
            image1.setReviewCode("rev1");
            image1.setImageUrl("/img1.png");

            imageRepository.save(image1);

            Image image2 = new Image();
            image2.setImageCode("img2");
            image2.setRestaurantCode("resto2");
            image2.setReviewCode("rev2");
            image2.setImageUrl("/img2.png");

            imageRepository.save(image2);
        }
    }

    @Transactional()
    public List<ImageResponse> getAllImages(){
        List<Image> images = imageRepository.findAll();
        return images.stream().map(this::mapToReviewResponse).toList();
    }

    @Transactional()
    public ImageResponse getImageByImageCode(String imageCode){
        Image image = imageRepository.findByImageCodeIn(Collections.singleton(imageCode));
        return mapToReviewResponse(image);
    }

    private ImageResponse mapToReviewResponse(Image image){
        return ImageResponse.builder()
                .id(image.getId())
                .reviewCode(image.getReviewCode())
                .restaurantCode(image.getRestaurantCode())
                .imageCode(image.getImageCode())
                .imageUrl(image.getImageUrl())
                .build();
    }
}
