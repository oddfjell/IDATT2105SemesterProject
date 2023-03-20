package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

public class Address {
    private int id;
    private String country;
    private String city;
    private int postalCode;
    private String streetName;
    private String streetNumber;

    public Address(){}

    public Address(int id, String country, String city, int postalCode, String streetName, String streetNumber) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}
