package ntnu.idatt2105.semesterProject.eCommerceMarketplace.controllers;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities.Item;
import ntnu.idatt2105.semesterProject.eCommerceMarketplace.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for all /item endpoints
 */
@RestController
@RequestMapping(value = "/item")
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ItemController {

    /**
     * ItemService field injection
     */
    @Autowired
    private ItemService itemService;

    /**
     * /createitem will return a boolen which tells
     * @param item
     * @return
     */
    @CrossOrigin
    @PostMapping("/createitem")
    public ResponseEntity<Boolean> createItem(@RequestBody Item item) {
        if(itemService.createItem(item)){
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    // Return all users
    @CrossOrigin
    @GetMapping("/service/getitems")
    public ResponseEntity<Iterable<Item>> getAllItems() {
        Iterable<Item> items = itemService.getAllItems();
        if(items == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(items, HttpStatus.OK);

    }
}
