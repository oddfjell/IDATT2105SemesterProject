package ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
