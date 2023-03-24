package ntnu.idatt2105.semesterProject.eCommerceMarketplace.model;

public class IsLogggedInRequest {
    private final String username;

    public IsLogggedInRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
