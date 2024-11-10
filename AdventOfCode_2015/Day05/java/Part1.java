import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part1 {
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
        return hasTreeVowels(line) && hasDoubleLetter(line) && noForbiddenSubstrings(line);
    }

    private static boolean noForbiddenSubstrings(String line) {
        String[] forbidden = {"ab", "cd", "pq", "xy"};
        for (String sub : forbidden) {
            if (line.contains(sub)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDoubleLetter(String line) {
        for (int i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) == line.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasTreeVowels(String line) {
        String vowels = "aeiou";
        return line.chars().filter(c -> vowels.contains(String.valueOf((char) c))).count() >= 3;
    }


}
