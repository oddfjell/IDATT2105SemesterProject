package ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int product_image_id;

    @Lob
    byte[] content;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="item_fk")
    @JsonBackReference
    private Item item;

    public int getProduct_image_id() {
        return product_image_id;
    }

    public byte[] getContent() {
        return content;
    }

    public Item getItem() {
        return item;
    }

    public void setProduct_image_id(int product_image_id) {
        this.product_image_id = product_image_id;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}