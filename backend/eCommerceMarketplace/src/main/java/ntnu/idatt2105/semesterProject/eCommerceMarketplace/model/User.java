package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

import java.sql.Date;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone_number;
    private String image;
    private String password;
    private Date date_of_birth;
    private Date registered;

    public User(){

    }
    public User(String username, String firstName, String lastName, String email, String phone_number, String image, String password, Date date_of_birth, Date registered) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone_number = phone_number;
        this.image = image;
        this.password = password;
        this.date_of_birth = date_of_birth;
        this.registered = registered;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
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
