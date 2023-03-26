package ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {}