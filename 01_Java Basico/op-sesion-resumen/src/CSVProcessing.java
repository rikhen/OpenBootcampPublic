import java.io.File;
import java.util.ArrayList;

public interface CSVProcessing {

  // CONSTANTS

  // METHODS
  public File openCSV(String filePath);
  public File createCSV(String filePath);
  public ArrayList<User> readCSV(String filePath);
  public boolean writeCSV(ArrayList<User> userList, String filePath);

}
