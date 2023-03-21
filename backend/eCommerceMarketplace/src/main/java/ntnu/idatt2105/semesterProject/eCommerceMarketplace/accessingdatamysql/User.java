package ntnu.idatt2105.semesterProject.eCommerceMarketplace.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone_number;
    private Date date_of_birth;
    private Date registered;
    private String image;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public Date getRegistered() {
        return registered;
    }

    public String getImage() {
        return image;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", image='" + image + '\'' +
                ", password='" + password + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", registered=" + registered +
                '}';
    }
}
