
package ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column (name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

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

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", briefDescription='" + briefDescription + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }
}

