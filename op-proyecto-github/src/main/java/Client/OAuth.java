package Client;

public class OAuth {

    // ATTRIBUTES
    private final String scheme = "bearer";
    private String token = "";
    private static OAuth oAuth;

    // CONSTRUCTORS
    private OAuth() {};

    // METHODS
    public static OAuth getInstance() {
        if (oAuth == null) {
            oAuth = new OAuth();
        }
        return oAuth;
    }
    public String authenticate() {
        return scheme + " " + getToken();
    }

    // GETTER & SETTER
    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
