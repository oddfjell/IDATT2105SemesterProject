
package ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table (name = "item")
public class Item {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "item_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "image")
    private String image;

    @Column(name = "for_sale")
    private boolean forSale;

    @ManyToOne
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "item_category", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
}

