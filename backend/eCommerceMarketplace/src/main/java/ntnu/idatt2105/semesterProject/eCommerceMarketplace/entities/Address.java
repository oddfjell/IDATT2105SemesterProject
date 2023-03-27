package ntnu.idatt2105.semesterProject.eCommerceMarketplace.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "address")
public class Address {
    /**
     * The address_id
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int id;

    /**
     * The country of the address
     */
    @Column(name = "country")
    private String country;

    /**
     * The city of the address
     */
    @Column(name = "city")
    private String city;

    /**
     * The postal code of the address
     */
    @Column(name = "postal_code")
    private int postalCode;

    /**
     * The street name of the address
     */
    @Column(name = "street_name")
    private String streetName;

    /**
     * The street number of the address
     */
    @Column(name = "street_number")
    private String streetNumber;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference
    private List<User> listOfUsers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
