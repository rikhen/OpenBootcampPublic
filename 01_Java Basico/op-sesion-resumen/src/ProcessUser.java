import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que trata los usuarios que le pasemos.
 * @author Josema / Henrik
 * @version 2.0
 */

public class ProcessUser implements UserProcessing {

  // ATTRIBUTES
  User user = null;
  private ArrayList<User> userList = new ArrayList<>();

  // CONSTRUCTORS
  public ProcessUser(){}

  // METHODS
  public static String formatID(Integer ID) {
    return String.format("%03d", ID);
  }

  /**
   * Método que cera un nuevo usuario
   * @param users Arraylist con los objetos del usuario
   */
  @Override
  public void createUser(ArrayList<User> users) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> userList = new ArrayList<String>();
    int index = users.size(); // Obtener el índice de usuario actual
    User user = null;
    String ID;
    String nombre;
    String apellido;
    String email;
    char addNewUser = 's';
    while(addNewUser == 's') {
      index++;
      System.out.println("Crear nuevo usuario");
      ID = formatID(index);
      scanner = new Scanner(System.in);
      System.out.println("Introduce nombre:");
      nombre = scanner.nextLine();
      scanner = new Scanner(System.in);
      System.out.println("Introduce apellido:");
      apellido = scanner.nextLine();
      scanner = new Scanner(System.in);
      System.out.println("Introduce email:");
      email = scanner.nextLine();
      user = new User(ID, nombre, apellido, email);
      System.out.println("¿Añadir más usuarios? [s/n]");
      addNewUser = scanner.next(".").charAt(0);
    }
    addUser(user);
  }

  /**
   * Método que añade un nuevo usuario a la lista
   * @param user objeto usuario
   */
  @Override
  public void addUser(User user) {
    this.userList.add(user);
  }

  /**
   * Método que selecta un usuario
   * @param users Arraylist con los objetos del usuario
   */
  @Override
  public void selectUser(ArrayList<User> users) {
    deleteUser(user);
  }

  /**
   * Método que borra un usuario de la lista
   * @param user objeto usuario
   */
  @Override
  public void deleteUser(User user) {
    this.userList.remove(user);
  }

  // GETTER & SETTER
  public ArrayList<User> getUserList() {return userList;}
  public void setUserList(ArrayList<User> userList) {this.userList = userList;}

}
