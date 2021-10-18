public class CSV {

  private String header;

  // Crea constructor vacío
  public CSV() {};

  public CSV(String header) {
    this.header = header;
  }

  // GETTER & SETTER
  public String getHeader() { return header; }

  public void setHeader(String header) { this.header = header; }

  @Override
  public String toString() {
    return "CSV{" +
        "header='" + header + '\'' +
        '}';
  }
}
