package openbootcamp;

/**
 * OpenBootcamp - Reto diario 05
 * @author Rikhen
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cadena []:");
        String inputString = scanner.nextLine();

        System.out.println(Util.stringToArray(inputString).toString());;
    }
}
