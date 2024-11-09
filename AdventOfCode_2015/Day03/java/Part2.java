import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Part2 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        Set<String> houses = new HashSet<>();
        int suppliers = 2; // about of helpers for scalability
        int[][] positions = new int[suppliers][2];


        // starting positions everyone starts at the same place
        for (int i = 0; i < suppliers; i++) {
            houses.add(positions[i][0] + "," + positions[i][1]);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            int direction;
            int turn = 0;
            while ((direction = reader.read()) != -1) {
                int currentHelper = turn % suppliers; // track which helper is currently delivering the presents
                switch ((char) direction) {
                    case '>' -> positions[currentHelper][0]++;
                    case '^' -> positions[currentHelper][1]++;
                    case '<' -> positions[currentHelper][0]--;
                    case 'v' -> positions[currentHelper][1]--;
                }
                houses.add(positions[currentHelper][0] + "," + positions[currentHelper][1]);
                turn++;
            }
            System.out.println(houses.size());
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
