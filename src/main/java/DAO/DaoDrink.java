package DAO;

import java.util.HashMap;
import java.util.List;
import model.Drink;
import util.Reader;

public class DaoDrink {

    private final HashMap<Integer, Drink> drinkHashMap = new HashMap<>();
    private final String drinks = "Drinks.txt";

    public HashMap<Integer, Drink> getDrinkHashMap() {
        List<String> drinksList = null;
        try {
            drinksList = Reader.readFile(drinks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int counter = 1;
        for (String drinkData : drinksList) {
            String[] singleDrinkData = drinkData.split(",");
            Drink drink = new Drink(singleDrinkData[0], Float.valueOf(singleDrinkData[1]));
            drinkHashMap.put(counter, drink);
            counter++;
        }
        return drinkHashMap;
    }


    public Drink getDrink(Integer key) {
        return drinkHashMap.get(key);
    }

}
