package Client;

public class Authentication {

    // ATTRIBUTES
    private final String scheme = "bearer ";
    private String token = "";

    // CONSTRUCTORS
    public Authentication() {};

    // METHODS
    public String authenticate() {
        return scheme+getToken();
    }

    // GETTER & SETTER
    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
