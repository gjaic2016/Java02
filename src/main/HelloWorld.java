package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {

        double kilometerAmount = 0;
        double conversionFactor;
        int miles;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite broj kilometara: ");
        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.println("Molimo unijeti brojčane vrijednosti!");
            }
            kilometerAmount = scanner.nextDouble();
//            scanner.nextLine();
            if (kilometerAmount < 0) {
                System.out.println("Molimo unesite pozitivan broj za broj kilometara!");
            }
        } while (kilometerAmount < 0);


        System.out.println("Unesite konverzijski faktor: ");
        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.println("Molimo unijeti brojčane vrijednosti!");
            }
            conversionFactor = scanner.nextDouble();
//            scanner.nextLine();
            if (conversionFactor < 0) {
                System.out.println("Molimo unesite pozitivan broj za konverzijski faktor!");
            }
        } while (conversionFactor < 0);

        scanner.close();

        File file = new File("konverzijski_faktor.txt");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(String.valueOf(conversionFactor));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        String sadrzaj = null;
        try {
            FileReader reader = new FileReader(file);
            char[] buffer = new char[10];
            reader.read(buffer);
            reader.close();
            sadrzaj = new String(buffer);
//            System.out.println("Sadržaj datoteke: " + sadrzaj);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        if (conversionFactor == Double.valueOf(sadrzaj)) {
//            System.out.println("Provjera broja: " + sadrzaj);
        miles = (int) (kilometerAmount / conversionFactor);
            System.out.println("Broj kilometara: " + kilometerAmount);
            System.out.println("Konverzijski faktor: " + conversionFactor);
            System.out.println("Uneseno je " + kilometerAmount + " kilometara,"
                    + " sto je " + miles + " milja.");

        } else {
            System.out.println("Konverzijski faktor nije isti kao u datoteci");
        }




    }
}
