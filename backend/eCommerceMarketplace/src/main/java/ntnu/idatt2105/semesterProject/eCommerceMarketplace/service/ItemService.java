package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for ItemController
 */
@Service
public class ItemService {

    /**
     * ItemRepository field injection
     */
    @Autowired
    private ItemRepository itemRepository;

    /**
     * CREATE item
     * Checks if the item does not already exist and adds it in the database
     * @param item Item
     * @return boolean
     */
    public boolean createItem(Item item) {
        try {
            itemRepository.save(item);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * GET items
     * Returns all items
     * @return Iterable<Item>
     */
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    /**
     * GET items from a user
     * Returns all items from a user
     * @param id int
     * @return Iterable<Item>
     */
    public Iterable<Item> getItemsByUserId(int id)  {
        return itemRepository.findItemsByUserId(id);

    }

    /**
     * DELETE item
     * Checks if the database has an item with the defined id. Then it deletes it
     * @param item Item
     * @return boolean
     */
    public boolean deleteItem(Item item) {
        // Check if user actually exist in database before deletion:
        if (!itemRepository.existsById(item.getId())) {
            System.out.println("Item with given id does not exist in database");
            return false;
        }
        itemRepository.deleteById(item.getId());
        return true;
    }
}
