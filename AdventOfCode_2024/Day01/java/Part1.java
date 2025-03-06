import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numb = line.trim().split("\\s+");
                firstList.add(Integer.parseInt(numb[0]));
                secondList.add(Integer.parseInt(numb[1]));
            }

            // Sort the lists
            Collections.sort(firstList);
            Collections.sort(secondList);

            int distance = 0;
            for (int i = 0; i < firstList.size(); i++) {
                distance += Math.abs(firstList.get(i) - secondList.get(i));
            }

            System.out.println(distance);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
