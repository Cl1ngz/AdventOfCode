import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Part2 {
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
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

        int similarityScore = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : secondList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int num : firstList) {
            int count = frequencyMap.getOrDefault(num, 0);
            similarityScore += count * num;
        }
        System.out.println(frequencyMap);

        System.out.println(similarityScore);

    }
}
