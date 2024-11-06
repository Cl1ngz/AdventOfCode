import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        int floor = 0;
        int position = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            int character;

            while ((character = reader.read()) != -1) {
                position++;
                floor += (character == '(') ? 1 : -1;

                if (floor == -1) {
                    System.out.println("Santa first enters the basement at positon: " + position);
                    return;
                }
            }
            System.out.println(floor);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
