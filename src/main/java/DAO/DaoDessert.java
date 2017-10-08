package DAO;

import java.util.HashMap;
import java.util.List;
import model.Dessert;
import util.Reader;

public class DaoDessert {
    private final HashMap<Integer, Dessert> dessertHashMap;
    private final String desserts = "Desserts.txt";

    public DaoDessert() {
        dessertHashMap = new HashMap<>();
    }

    public HashMap<Integer, Dessert> getDessertHashMap() {
        List<String> dessertsList = null;
        try {
            dessertsList = Reader.readFile(desserts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int counter = 1;
        for (String dessertData : dessertsList) {
            String[] singleDessertData = dessertData.split(",");
            Dessert dessert = new Dessert(singleDessertData[0],
                Float.valueOf(singleDessertData[1]));
            dessertHashMap.put(counter, dessert);
            counter++;
        }
        return dessertHashMap;
    }


    public Dessert getDessert(Integer key) {
        return dessertHashMap.get(key);
    }

}
