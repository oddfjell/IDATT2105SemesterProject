package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.ProductImage;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true")
@EnableAutoConfiguration
class ProductImageController {

    @Autowired
    ProductImageRepository productImageRepository;

    @CrossOrigin
    @PostMapping("/image")
    boolean uploadImage(@RequestParam MultipartFile multipartImage, Item item) throws Exception {

        try {
            ProductImage productImage = new ProductImage();
            productImage.setContent(multipartImage.getBytes());
            productImage.setItem(item);

            productImageRepository.save(productImage);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/image/{imageId}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    ByteArrayResource downloadImage(@PathVariable int imageId) {
        byte[] image = productImageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getContent();

        return new ByteArrayResource(image);
    }
}
