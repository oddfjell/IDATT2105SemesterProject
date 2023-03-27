package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

/**
 * LoginResponse is to
 */
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

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
