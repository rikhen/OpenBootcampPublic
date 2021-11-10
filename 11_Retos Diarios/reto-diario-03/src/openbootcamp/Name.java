package openbootcamp;

/**
 * OpenBootcamp - Reto diario 03
 * Clase que procesa la entrada del usuario y emite el nombre del compuesto introducido por separado
 * @author Rikhen
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class Name {

    // ATTRIBUTES
    private String firstname;
    private String middlename;
    private String firstSurename;
    private String secondSurename;
    private String fullName;
    private Boolean compound;
    private final String filePath = "compounds.txt";

    // CONSTRUCTORS
    public Name() {
    }

    public Name(String firstname) {
        this.firstname = firstname;
    }

    public Name(String firstname, String firstSurename) {
        this.firstname = firstname;
        this.firstSurename = firstSurename;
    }

    public Name(String firstname, String middlename, String firstSurename, String secondSurename) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.firstSurename = firstSurename;
        this.secondSurename = secondSurename;
    }

    public String printFullname(String completeName) {
        getFirstname();
        return completeName;
    }

    // METHODS
    /**
     * Método que divide el nombre introducido en cadenas individuales
     * @param fullName nombre introducido a través de la consola
     */
    public void splitName(String fullName) {
        String[] nameArray = fullName.split("\\s+", -1);
        switch (nameArray.length) {
            case 1:
                firstname = nameArray[0];
                setFirstname(firstname);
                System.out.println("Nombre: " + firstname);
                break;
            case 2:
                if (isCompound(nameArray[0] + " " + nameArray[1])) {
                    firstname = nameArray[0] + " " + nameArray[1];
                    setFirstname(firstname);
                    System.out.println("Nombre: " + firstname);
                } else {
                    firstname = nameArray[0];
                    firstSurename = nameArray[1];
                    setFirstSurename(firstname);
                    System.out.println("Nombre: " + firstname);
                    System.out.println("Primer apellido: " + firstSurename);
                }
                break;
            case 3:
                if (isCompound(nameArray[0] + " " + nameArray[1])) {
                    firstname = nameArray[0] + " " + nameArray[1];
                    firstSurename = nameArray[2];
                    setFirstSurename(firstSurename);
                    setFirstname(firstname);
                    System.out.println("Nombre: " + firstname);
                    System.out.println("Primer apellido: " + firstSurename);
                } else {
                    firstname = nameArray[0];
                    firstSurename = nameArray[1];
                    secondSurename = nameArray[2];
                    setFirstname(firstname);
                    setFirstSurename(firstSurename);
                    setSecondSurename(secondSurename);
                    System.out.println("Nombre: " + getFirstname());
                    System.out.println("Primer apellido: " + firstSurename);
                    System.out.println("Segundo apellido: " + secondSurename);
                }
                break;
            case 4:
                firstname = nameArray[0] + " " + nameArray[1];
                firstSurename = nameArray[2];
                secondSurename = nameArray[3];
                setFirstname(firstname);
                setFirstSurename(firstSurename);
                setSecondSurename(secondSurename);
                System.out.println("Nombre: " + firstname);
                System.out.println("Primer apellido: " + firstSurename);
                System.out.println("Secundo apellido: " + secondSurename);
                break;
            default:
                System.out.println("El nombre introducido no es válido!");
        }
    }

    /**
     * Método que comprueba si el nombre es un nombre compuesto
     * El archivo compounds.txt contiene todos los nombres compuestos
     * @param name nombre introducido a través de la consola
     * @return Boolean
     */
    public Boolean isCompound(String name) {
        name = name.trim();

        compound = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.contains(name))
                {
                    compound = true;
                    break;
                }
                else
                {
                    compound = false;
                }
            }
        } catch (Exception e) {
            compound = false;
            System.out.println("Se ha producido un error! " + e.getMessage());
        }
        return compound;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", firstSurename='" + firstSurename + '\'' +
                ", secondSurename='" + secondSurename + '\'' +
                ", fullName='" + fullName + '\'' +
                ", compound=" + compound +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    // GETTER & SETTER
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFirstSurename() {
        return firstSurename;
    }

    public void setFirstSurename(String firstSurename) {
        this.firstSurename = firstSurename;
    }

    public String getSecondSurename() {
        return secondSurename;
    }

    public void setSecondSurename(String secondSurename) {
        this.secondSurename = secondSurename;
    }
}
