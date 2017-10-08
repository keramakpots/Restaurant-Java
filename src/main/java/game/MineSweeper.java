package game;



public class MineSweeper implements IMineSweeper {

    private String map = null;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        if (mineField == null || mineField.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] lines = mineField.split("\r\n|\r|\n");
        int length = 0;
        for (String line : lines) {
            if (length == 0) {
                length = line.length();
            } else if (length != line.length()) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c != '.' && c != '*') {
                    throw new IllegalArgumentException();
                }
            }
        }
        map = mineField;
    }

    @Override
    public String getHintField() throws IllegalStateException {
        StringBuilder stringBuilder = new StringBuilder();
        if (map == null) {
            throw new IllegalStateException();
        } else {
            String[] lines = map.split("\r\n|\r|\n");
            String[][] chars = new String[lines.length][lines[0].length()];
            int[][] table = new int[lines.length][lines[0].length()];
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    chars[i][j] = lines[i].substring(j, j + 1);
                    if (chars[i][j].equals("*")) {
                        try {
                            table[i - 1][j - 1] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i - 1][j] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i - 1][j + 1] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i][j - 1] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i][j + 1] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i + 1][j - 1] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i + 1][j] += 1;
                        } catch (Exception e) {
                        }
                        try {
                            table[i + 1][j + 1] += 1;
                        } catch (Exception e) {
                        }
                    }
                }
            }
            for (int i = 0; i < table.length; i++) {
                StringBuilder lineBuilder = new StringBuilder();
                for (int j = 0; j < table[i].length; j++) {
                    lineBuilder.append(table[i][j]);
                    if (chars[i][j].equals("*")) {
                        lineBuilder.replace(j, j + 1, "*");
                    }
                }
                stringBuilder.append(lineBuilder.toString());
                stringBuilder.append("\n");
            }
            return stringBuilder.toString().trim();
        }
    }
}
