public class Main {

  public static void main(String[] args) {

    String userDataIn = "userdata.csv";
    String userDataOut = "userdataOut.csv";

    ProcessFile userFile = new ProcessFile(userDataIn);
    ProcessUser userList = new ProcessUser();

    userFile.openCSV(userFile.getFilePath());
    userList.setUserList(userFile.readCSV(userFile.getFilePath()));
    userList.createUser(userList.getUserList());
    userFile.writeCSV(userList.getUserList(), userDataOut);
  }
}
