package ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * Address table
 */
@Entity
@Table (name = "address")
public class Address {

    /**
     * COLUMNS
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int id;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private String streetNumber;

    /**
     * JOIN
     */
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    private List<User> listOfUsers;

    /**
     * GETTERS
     */
    public int getId() {
        return id;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public String getStreetName() {
        return streetName;
    }
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * SETTERS
     */
    public void setId(int id) {
        this.id = id;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
