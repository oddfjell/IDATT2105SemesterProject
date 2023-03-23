package ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table (name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String title;

    @ManyToMany(mappedBy = "categories")
    private List<Item> items;

    public Category() {

    }

    public Category(int id, String title, List<Item> items) {
        this.id = id;
        this.title = title;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
