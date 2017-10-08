package ui;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class InputGetter {

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static String getStringInput() {
        Scanner scanner = getScanner();
        return scanner.next();
    }

    public static Integer getIntegerInput() {
        Scanner scanner = getScanner();
        boolean bError = true;
        Integer intInput = 0;
        while (bError) {
            try {
                if (scanner.hasNextInt()) {
                    intInput = scanner.nextInt();
                }
            } catch (Exception e) {
                System.out.print(e.toString());
                scanner.reset();
                scanner.hasNextInt();
                continue;
            }
            bError = false;
        }
        return intInput;
    }

    public static Float getFloatInput() {
        Scanner scanner = getScanner();
        scanner.useLocale(Locale.US);
        Float price = 0.0f;
        Boolean search = true;
        while (search) {
            System.out.print("Enter a float price: ");
            try {
                price = scanner.nextFloat();
                search = false;
            } catch (InputMismatchException ime) {
                System.out.println(ime.toString());
                scanner.reset();
                scanner.next();
            }
        }
        return price;
    }
}

