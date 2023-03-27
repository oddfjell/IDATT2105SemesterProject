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
     * /createitem will send the creation request to itemservice. Then it will return a ResponseEntity<Boolean>
     * which tells weather the creation was successful or not with a boolean and a http status
     * @param item Item
     * @return ResponseEntity<Boolean>
     */
    @CrossOrigin
    @PostMapping("/createitem")
    public ResponseEntity<Boolean> createItem(@RequestBody Item item) {
        if(itemService.createItem(item)){
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    /**
     * /service/getitems is a "public endpoint"
     * /service/getitems will send the getAllItems request to itemservice. Then it will return either an
     * Iterable<Item> with all the items and a 200 http status, ur just a 404 http status
     * @return ResponseEntity<Iterable<Item>>
     */
    @CrossOrigin
    @GetMapping("/service/getitems")
    public ResponseEntity<Iterable<Item>> getAllItems() {
        Iterable<Item> items = itemService.getAllItems();
        if(items == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(items, HttpStatus.OK);

    }

    /**
     * /{id} will send the getItemsByUserId request to itemservice. Then it will return a either a Iterable<Item> with
     * all the items of one user and a 200 http status, ur just a 404 http status
     * @param id int
     * @return ResponseEntity<Iterable<Item>>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Item>> getItemsByUserId(@PathVariable int id)  {
        Iterable<Item> items = itemService.getItemsByUserId(id);
        if(items == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(items, HttpStatus.OK);

    }

    /**
     * /delete will send the deleteItem request to itemservice. Then it will return a ResponseEntity<> with a
     * 200 http status or a 404 http status
     * @param item ITEM
     * @return ResponseEntity<>
     */
    @DeleteMapping ("/delete")
    public ResponseEntity<Iterable<Item>> deleteItem(@RequestBody Item item)  {
        boolean gotDeleted = itemService.deleteItem(item);
        if(gotDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
