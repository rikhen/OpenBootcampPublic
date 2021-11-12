package openbootcamp;
/**
 * OpenBootcamp - Reto diario 04
 * Clase que convierte una cadena de tipo String en un ArrayList de integer
 * @author Rikhen
 * @version 1.0
 */

import java.util.ArrayList;

public class Util {

    // METHODS

    /**
     * Método que lee una cadena y lo descompone en elementos individuales
     * @param inputString
     * @return Boolean
     */
    public static ArrayList<Integer> stringToArray(String inputString) throws NumberFormatException {
        ArrayList<Integer> integerArray = new ArrayList();
        // Comprueba si el formato es correcto
        if (inputString.startsWith("[") && inputString.endsWith("]")) {
            // Descompone la cadena
            String[] stringArray = inputString.replaceAll("\\[", "")
                    .replaceAll("]", "").split(",");
            for (String string : stringArray) {
                // Comprueba si el elemento es un integer
                if(isInteger(string)) {
                    integerArray.add(Integer.parseInt(string));
                } else {
                    throw new NumberFormatException("\"" + string + "\"[" + " no es un integer!");
                }
            }
        } else {
            throw new NumberFormatException("El formato de la cadena no está correcto!");
        }
        return integerArray;
    }

    /**
     * Método que comprueba si el elemento es un integer
     * @param elemento
     * @return Boolean
     */
    private static boolean isInteger(String elemento) {
        try {
            Integer.parseInt(elemento);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

}
