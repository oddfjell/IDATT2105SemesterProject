package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.ProductImage;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    ProductImageRepository productImageRepository;


    boolean uploadImage(List<MultipartFile> listOfMultipartFiles) throws Exception {

        try {
            for (MultipartFile multipartFile : listOfMultipartFiles) {
                ProductImage productImage = new ProductImage();
                productImage.setContent(multipartFile.getBytes());
                productImageRepository.save(productImage);
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
