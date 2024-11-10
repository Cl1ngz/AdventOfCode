import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part2 {
    public static void main(String[] args) {
        String filepath = "../input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (isNice(line)) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }

    private static boolean isNice(String line) {
        return hasPairThatAppearsTwice(line) && hasLetterWithOneBetween(line);
    }

    private static boolean hasLetterWithOneBetween(String line) {
        for (int i = 0; i < line.length() - 2; i++) {
            if (line.charAt(i) == line.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasPairThatAppearsTwice(String line) {
        for (int i = 0; i < line.length() - 1; i++) {
            String pair = line.substring(i, i + 2);

            for (int j = i + 2; j < line.length() - 1; j++) {
                if (line.substring(j, j + 2).equals(pair)) {
                    return true;
                }
            }
        }
        return false;
    }


}
