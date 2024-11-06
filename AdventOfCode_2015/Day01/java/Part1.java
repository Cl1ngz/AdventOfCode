import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        int floor = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            int character;

            while ((character = reader.read()) != -1) {
                if (character == '(') {
                    floor++;
                } else if (character == ')') {
                    floor--;
                }
            }
            System.out.println(floor);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}

