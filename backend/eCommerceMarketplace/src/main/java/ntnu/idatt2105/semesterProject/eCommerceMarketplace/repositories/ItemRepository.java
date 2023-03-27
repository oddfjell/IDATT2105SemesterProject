package ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories;

import org.springframework.data.repository.CrudRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
 * CRUD refers Create, Read, Update, Delete
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    /**
     * READ / GET items from spesific user
     * @param UserId int
     * @return List<Item>
     */
    List<Item> findItemsByUserId(int UserId);
    /**
     * DELETE id
     * @param id int
     * @return Boolean
     */
    public Boolean deleteById(int id);

}
