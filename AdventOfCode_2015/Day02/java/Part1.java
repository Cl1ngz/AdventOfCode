import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                List<Integer> dim = Arrays.stream(line.split("x")).map(Integer::parseInt).toList();
                int l = dim.get(0);
                int w = dim.get(1);
                int h = dim.get(2);
                int lw = l * w;
                int wh = w * h;
                int lh = l * h;
                int extra = Math.min(Math.min(lw, wh), lh);
                total += 2 * lw + 2 * wh + 2 * lh + extra;
            }
            System.out.println(total);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}