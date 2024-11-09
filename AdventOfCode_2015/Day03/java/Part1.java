import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        Set<String> houses = new HashSet<>();
        int x = 0, y = 0;
        houses.add(x + "," + y);

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            int direction;
            while ((direction = reader.read()) != -1) {
                switch ((char) direction) {
                    case '>' -> x++;
                    case '^' -> y++;
                    case '<' -> x--;
                    case 'v' -> y--;
                }
                houses.add(x + "," + y);
            }
            System.out.println(houses.size());
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
