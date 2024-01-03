package fact.it.imageservice;

import fact.it.imageservice.dto.ImageRequest;
import fact.it.imageservice.dto.ImageResponse;
import fact.it.imageservice.model.Image;
import fact.it.imageservice.repository.ImageRepository;
import fact.it.imageservice.service.ImageService;
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
public class ImageServiceUnitTest {

    @InjectMocks
    private ImageService imageService;

    @Mock
    private ImageRepository imageRepository;

    @Test
    public void testGetAllImages() {
        // Arrange
        Image image = new Image();
        image.setId("1");
        image.setImageUrl("test");
        image.setImageCode("img1");
        image.setReviewCode("rev1");
        image.setRestaurantCode("resto1");

        when(imageRepository.findAll()).thenReturn(Arrays.asList(image));

        // Act
        List<ImageResponse> images = imageService.getAllImages();

        // Assert
        assertEquals(1, images.size());
        assertEquals("test", images.get(0).getImageUrl());
        assertEquals("img1", images.get(0).getImageCode());
        assertEquals("rev1", images.get(0).getReviewCode());
        assertEquals("resto1", images.get(0).getRestaurantCode());

        verify(imageRepository, times(1)).findAll();
    }

    @Test
    public void testGetImageByImageCode() {
        // Arrange
        Image image = new Image();
        image.setId("1");
        image.setImageUrl("test");
        image.setImageCode("img1");
        image.setReviewCode("rev1");
        image.setRestaurantCode("resto1");

        when(imageRepository.findByImageCodeIn(Collections.singleton("img1"))).thenReturn(image);

        // Act
        ImageResponse image1 = imageService.getImageByImageCode("img1");

        // Assert
        assertEquals("test", image1.getImageUrl());
        assertEquals("img1", image1.getImageCode());
        assertEquals("rev1", image1.getReviewCode());
        assertEquals("resto1", image1.getRestaurantCode());

        verify(imageRepository, times(1)).findByImageCodeIn(Collections.singleton(image.getImageCode()));
    }
}