package githubAPI;

public class User {

  // ATTRIBUTES
  private String name;
  private String token;

  // CONSTRUCTORS
  public User() {};

  public User(String name) {
    this.name = name;
  }

  // METHODS

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            "token='" + token + '\'' +
            '}';
  }

  // GETTER & SETTER
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
