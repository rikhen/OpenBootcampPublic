import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Clase que trata el fichero csv que le pasemos.
 * Leera y escribirá en el.
 * @author Josema / Henrik
 * @version 2.0
 */

public class ProcessFile implements CSVProcessing {

  // ATTRIBUTES
  private ArrayList<User> userList = new ArrayList<>();
  private CSV csv = new CSV();
  private String filePath;
  private File file = null;
  private String HEADER = "ID;name;lastname;email";

  // CONSTRUCTORS

  public ProcessFile() {}
  /**
   * Constructor con la ruta del fichero
   * @param filePath ruta del fichero
   */
  public ProcessFile(String filePath) {
    this.filePath = filePath;
  }

  // METHODS

  /**
   * Método que abre el archivo CSV o llama el método para crear uno nuevo si no existe
   * @param filePath ruta del fichero a leer
   * @return un objeto tipo File del fichero
   */
  @Override
  public File openCSV(String filePath) {
    System.out.print("Abriendo fichero...");
    File file = new File(filePath);
    if (file.exists()) {
      try {
        InputStream in = new FileInputStream(filePath);
      } catch (Exception e) {
        System.out.println("Se ha producido un error abriendo!" + e.getMessage());
      } finally {
        System.out.println("Fichero abierto!");
      }
    } else {
      System.out.println("No se ha encontrado el fichero!");
      file = createCSV(filePath);
    }
    return file;
  }

  /**
   * Método que crea un nuevo archivo CSV
   * @param filePath ruta del fichero a crear
   * @return un objeto tipo File del fichero
   */
  @Override
  public File createCSV(String filePath) {
    BufferedWriter bufferedData = null;
    csv.setHeader(HEADER);
    try {
      File file = new File(filePath);
      System.out.print("Creando fichero...");
      bufferedData = new BufferedWriter(new FileWriter(filePath));
      bufferedData.write(csv.getHeader());
      bufferedData.newLine();
      bufferedData.close();
    } catch (Exception e) {
      System.out.println("Se ha producido un error creando fichero!" + e.getMessage());
    } finally {
      System.out.println("Fichero creado!");
    }
    return file;
}

  /**
   * Método que lee el archivo CSV
   * @param filePath ruta del fichero a leer
   * @return Arraylist con los objetos que tiene el fichero
   */
  @Override
  public ArrayList<User> readCSV(String filePath) {
    BufferedReader bufferedData = null;
    csv.setHeader(HEADER);
    String line = null;
    User user = null;
    try {
      System.out.println("Leyendo fichero...");
      bufferedData = new BufferedReader(new FileReader(filePath));
      userList.clear();
      csv.setHeader(bufferedData.readLine());
      while((line = bufferedData.readLine()) != null) {
        user = createUser(line);
        userList.add(user);
        System.out.println(user.toString());
      }
    } catch (Exception e) {
      System.out.println("Se ha producido un error leyendo el fichero!" + e.getMessage());
    }
    finally {
      try {
        bufferedData.close();
      } catch (IOException e) {
        System.out.println("Se ha producido un error leyendo el fichero!" + e.getMessage());
      } finally {
        System.out.println("Fichero leído!");
        //System.out.println(userList);
      }
      }
    return userList;
  }

  /**
   * Método que escribe en el archivo las lineas con los objetos.
   * @param userList lista de Usuarios
   * @param filePath ruta del fichero a escribir
   * @return true si se realizo bien la operacion y false si fallo algo
   */

  @Override
  public boolean writeCSV(ArrayList<User> userList, String filePath) {
    BufferedWriter bufferedData = null;
    String newLine;
    User user = null;
    StringBuilder line = new StringBuilder();
    boolean success;
    try {
      System.out.println("Escribiendo fichero...");
      File file = new File(filePath);
      bufferedData = new BufferedWriter(new FileWriter(filePath));
      bufferedData.write(csv.getHeader());
      bufferedData.newLine();
      for (User u : userList) {
        bufferedData.write(writeLine(u,line));
        bufferedData.flush();
        System.out.println(u.toString());
      }
      success = true;
    } catch (Exception e) {
      System.out.println("Se ha producido un error escribiendo el fichero!" + e.getMessage());
      success = false;
    } finally {
      try {
        bufferedData.close();
      } catch (IOException e) {
        System.out.println("Se ha producido un error cerrando el fichero!" + e.getMessage());
        success = false;
      } finally {
        System.out.println("Fichero escrito!");
        success = true;
      }
    }
    return success;
  }

  /**
   * Crea un objeto usuario a partir de un linea del achivo leido
   * @param line del archivo leido
   * @return objeto Usuario
   */
  private User createUser(String line) {
    User user = null;
    String[] userAttributes;
    userAttributes = line.split(";");
    for (String s : userAttributes) {
      // System.out.println(s);
    }
    user = new User(userAttributes[0],userAttributes[1],userAttributes[2],userAttributes[3]);
    return user;
  }

  /**
   * Metodo que crea el la linea a escribir en el archivo
   * @param user Objeto Usuario
   * @param line StringBuilder
   * @return String formado listo para escribir
   */
  public String writeLine(User user,StringBuilder line){
    String newLine;
    line.append(user.getID());
    line.append(";");
    line.append(user.getName());
    line.append(";");
    line.append(user.getLastname());
    line.append(";");
    line.append(user.getEmail());
    line.append("\r\n");
    newLine = line.toString();
    line.setLength(0);
    return newLine;
  }

  // GETTER & SETTER
  public String getFilePath() {return filePath;}
  public void setFilePath(String filePath) {this.filePath = filePath;}
}
