package DAO;

import java.util.List;
import util.Reader;

public class DaoCuisuines {
    private static final String cuisuinesFile = "Cuisuines.txt";

    public static List<String> loadCuisuines() {
        List<String> cuisuines = null;
        try {
            cuisuines = Reader.readFile(cuisuinesFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuisuines;
    }

}
