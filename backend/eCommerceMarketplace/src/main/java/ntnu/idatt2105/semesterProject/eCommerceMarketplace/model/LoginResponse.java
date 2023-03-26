package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

public class LoginResponse {
    private String jwt;
    private int id;

    public LoginResponse(String jwt, int id) {
        this.jwt = jwt;
        this.id = id;
    }

    public String getJwt() {
        return jwt;
    }

    public int getId() {
        return id;
    }
}
