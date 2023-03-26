package ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue
    int id;

    @Lob
    byte[] content;

    String name;

    public int getId() {
        return id;
    }

    public byte[] getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }
}