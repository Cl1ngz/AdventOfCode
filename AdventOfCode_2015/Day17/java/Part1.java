import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
