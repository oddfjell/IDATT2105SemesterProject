package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * create
     * @param item
     * @return
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
     * Return all items
     * @return
     */
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }
}