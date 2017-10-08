package view;


import DAO.DaoCuisuines;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    private static final ArrayList<String> mainMenu = new ArrayList<>(
        Arrays.asList("Welcome in Stopka's Restaurant",
            " ",
            "Choose option",
            "[1] Choose Lunch.",
            "[2] Choose Drink.",
            "[3] Overview",
            "[4] Payment.",
            "[0] EXIT."));

    public static List<String> getCuisuines() {
        List<String> cuisuines = new ArrayList<>();
        for (String cuisuine : DaoCuisuines.loadCuisuines()) {
            cuisuines.add(cuisuine);
        }
        return cuisuines;
    }

    public static ArrayList<String> getMainMenu() {
        return mainMenu;
    }
}
