package ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;

// This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
// CRUD refers Create, Read, Update, Delete

public interface ItemRepository extends CrudRepository<Item, Integer> {

    public boolean deleteById(int id);

}
