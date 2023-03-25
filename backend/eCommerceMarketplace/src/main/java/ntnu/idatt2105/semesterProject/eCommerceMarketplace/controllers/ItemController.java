package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.repositories.ItemRepository;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/item")
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ItemController {

    private ItemService itemService;

    @CrossOrigin
    @PostMapping("/createitem")
    public @ResponseBody boolean createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    // Return all users
    @CrossOrigin
    @GetMapping("/service/getitems")
    public @ResponseBody Iterable<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
