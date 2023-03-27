package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

/**
 * LoginResponse class
 */
public class LoginResponse {

    private String jwt;
    private int id;
    private String role;

    /**
     * Constructor
     * @param jwt String
     * @param id int
     * @param role String
     */
    public LoginResponse(String jwt, int id, String role) {
        this.jwt = jwt;
        this.id = id;
        this.role = role;
    }

    /**
     * GETTERS
     */
    public String getJwt() {
        return jwt;
    }
    public int getId() {
        return id;
    }
    public String getRole() {
        return role;
    }

    /**
     * SETTERS
     */
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
