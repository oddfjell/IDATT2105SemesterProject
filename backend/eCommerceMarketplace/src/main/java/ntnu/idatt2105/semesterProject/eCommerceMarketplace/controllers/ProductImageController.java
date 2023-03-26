package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

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
    int uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
        System.out.println("vises dette?");
        ProductImage productImage = new ProductImage();
        productImage.setName(multipartImage.getName());
        productImage.setContent(multipartImage.getBytes());

        return productImageRepository.save(productImage).getId();
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
