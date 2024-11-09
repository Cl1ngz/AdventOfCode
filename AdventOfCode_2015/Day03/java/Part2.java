import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Part2 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        Set<String> houses = new HashSet<>();
        int santaX = 0, santaY = 0;
        int roboX = 0, roboY = 0;
        houses.add(santaX + "," + santaY);

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            int direction;
            boolean turn=true;
            while ((direction = reader.read()) != -1) {
                if(turn){
                    switch ((char) direction) {
                        case '>' -> santaX++;
                        case '^' -> santaY++;
                        case '<' -> santaX--;
                        case 'v' -> santaY--;
                    }
                    houses.add(santaX + "," + santaY);
                }else {
                    switch ((char) direction) {
                        case '>' -> roboX++;
                        case '^' -> roboY++;
                        case '<' -> roboX--;
                        case 'v' -> roboY--;
                    }
                    houses.add(roboX + "," + roboY);
                }
                turn=!turn;
            }
            System.out.println(houses.size());
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
