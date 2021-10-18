import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Clase hija Password de la clase User
 * @author Josema / Henrik
 * @version 2.0
 */

public class Password extends User {

  String password;

  // Crea constructor vacío
  public Password() {
  }

  // Sobrecarga el constructor
  public Password(String ID, String password) {
    super(ID);
    this.password = password;
  }

  // METHODS
  public static String generatePassword() {
    byte[] array = new byte[8]; // length is bounded by 7
    new Random().nextBytes(array);
    String password = new String(array, StandardCharsets.UTF_8);
    System.out.println(password);
    return password;
  }

  // GETTER & SETTER
  public String getPassword() {return password;}
  public void setPassword(String password) {this.password = password;}

  @Override
  public String toString() {
    return "Password{" +
        "password='" + password + '\'' +
        '}';
  }

}
