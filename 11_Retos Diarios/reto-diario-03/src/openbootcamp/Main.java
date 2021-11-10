package openbootcamp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Name> names = new ArrayList();
        Name name = new Name();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un nombre:");
        String fullName = scanner.nextLine();

        name.splitName(fullName);

    }
}
