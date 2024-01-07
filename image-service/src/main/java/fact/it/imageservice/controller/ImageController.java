package fact.it.imageservice.controller;

import fact.it.imageservice.dto.ImageResponse;
import fact.it.imageservice.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ImageResponse> getAllImages(){
        return imageService.getAllImages();
    }

    @GetMapping("/get/{imageCode}")
    @ResponseStatus(HttpStatus.OK)
    public ImageResponse getImageByImageCode(@PathVariable String imageCode){
        return imageService.getImageByImageCode(imageCode);
    }
}
