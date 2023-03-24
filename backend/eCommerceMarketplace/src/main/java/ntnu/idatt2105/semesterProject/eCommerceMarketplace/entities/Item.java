
package ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities;

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

    @Column(name = "briefDescription")
    private String briefDescription;

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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public boolean isForSale() {
        return forSale;
    }

    public User getUser() {
        return user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

