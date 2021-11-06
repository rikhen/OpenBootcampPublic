package githubAPI;

public class Authentication {

    // ATTRIBUTES
    private final String scheme = "bearer ";
    private String token = "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";

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
