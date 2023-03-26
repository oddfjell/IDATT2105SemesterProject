package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

public class LoginResponse {
    private String jwt;
    private int id;
    private String role;

    public LoginResponse(String jwt, int id, String role) {
        this.jwt = jwt;
        this.id = id;
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
