package ntnu.idatt2105.semesterProject.eCommerceMarketplace.service;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.model.LoginResponse;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.ItemRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public boolean createItem(Item item) {
        try {
            itemRepository.save(item);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Returns all items
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }


    public boolean deleteItem(Item item) {

        // Check if user actually exist in database before deletion:
        if (!itemRepository.existsById(item.getId())) {
            System.out.println("Item with given id does not exist in database");
            return false;
        }

        itemRepository.deleteById(item.getId());
        return true;
    }

    public List<Item> getItemsByUserId(int userId){
        return itemRepository.findItemsByUserId(userId);
    }
}
