package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

public class UserInfoResponse {
    final private String username;
    final private String password;

    public UserInfoResponse(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
