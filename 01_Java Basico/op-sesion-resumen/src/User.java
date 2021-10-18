/**
 * Clase User
 * @author Josema / Henrik
 * @version 2.0
 */

public class User {

  // ATTRIBUTES
  private String ID;
  private String name;
  private String lastname;
  private String email;
  private String password;

  // Crea constructor vacío
  public User() {
  }

  /**
   * Constructor con parámetro ID para asignar una contraseña al usuario
   * @param ID ID del Usuario
   */
  public User(String ID) {
    this.ID = ID;
  }

  /**
   * Constructor con parametros
   * @param ID ID del Usuario
   * @param name nombre del usuario
   * @param lastname apellido del usuario
   * @param email del usuario
   */
  public User(String ID, String name, String lastname, String email) {
    this.ID = ID;
    this.name = name;
    this.lastname = lastname;
    this.email = email;
  }

  // METHODS

  @Override
  public String toString() {
    return "User{" +
        "ID='" + ID + '\'' +
        ", name='" + name + '\'' +
        ", lastname='" + lastname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  //GETTER & SETTER
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String apellido) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
