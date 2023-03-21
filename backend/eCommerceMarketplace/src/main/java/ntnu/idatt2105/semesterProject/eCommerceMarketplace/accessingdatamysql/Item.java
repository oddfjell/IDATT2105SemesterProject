package ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql;

import ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql.User;

import java.util.List;

public class Item {
    private int id;
    private String title;
    private String description;
    private String full_description;
    private double price;
    private String image;
    private User user;
    private List<Category> categories;
    private boolean for_sale;
    private Address address;

    public Item() {
    }

    public Item(int id, String title, String description, String full_description, double price, String image, ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql.User user, List<Category> categories, boolean for_sale, Address address) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.full_description = full_description;
        this.price = price;
        this.image = image;
        this.user = user;
        this.categories = categories;
        this.for_sale = for_sale;
        this.address = address;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean isFor_sale() {
        return for_sale;
    }

    public void setFor_sale(boolean for_sale) {
        this.for_sale = for_sale;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", full_description='" + full_description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", user=" + user +
                ", categories=" + categories +
                ", for_sale=" + for_sale +
                ", address=" + address +
                '}';
    }
}

