package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> readFile(String filename) throws Exception {
        String line = null;
        List<String> records = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        while ((line = bufferedReader.readLine()) != null) {
            records.add(line);
        }
        bufferedReader.close();
        return records;
    }

}
