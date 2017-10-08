package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Dessert;
import model.Drink;
import model.Lunch;
import model.Order;

public class Printer {

    public static void printDrinkHashMap(HashMap<Integer, Drink> hashMap) {
        int i = 1;
        System.out.println("Drink:         Price: ");
        for (Integer key : hashMap.keySet()
            ) {
            Drink drink = hashMap.get(key);
            System.out.println(i + ". " + drink.getName() + " , " + drink.getPrice());
            i++;
        }
    }

    public static void printObject(String stringObject) {
        System.out.println(stringObject);
    }

    public static void printOrder(Order order) {
        Float overall = 0f;
        System.out.println("Lunch: ");
        for (Lunch lunch : order.getLunch()
            ) {
            System.out.println(lunch.toString());
            overall += lunch.getPrice();
        }
        if (order.getDrinks().size() > 0) {
            System.out.println("Drinks: ");
            for (Drink drink : order.getDrinks()
                ) {
                System.out.println(drink.getName() + " " + drink.getPrice());
                overall += drink.getPrice();
            }
        }
        System.out.println("Overall price: " + overall);
    }

    public static void printBreak() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public static void printMenu(ArrayList<String> options) {
        Printer.printBreak();
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static void printOption(List<String> options) {
        Printer.printBreak();
        int i = 1;
        for (String option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
    }

    public static void printDessertHashMap(HashMap<Integer, Dessert> dessertHashMap) {
        int i = 1;
        System.out.println("Dessert:         Price: ");
        for (Integer key : dessertHashMap.keySet()
            ) {
            Dessert dessert = dessertHashMap.get(key);
            System.out.println(i + ". " + dessert.getName() + ", " + dessert.getPrice());
            i++;
        }
    }
}
