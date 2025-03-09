import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        Set<String> locations = new HashSet<>();

        // Location-> map that gives distanse to other location
        Map<String, Map<String, Integer>> distances = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tkns = line.split(" ");
                String loc1 = tkns[0];
                String loc2 = tkns[2];

                int dist = Integer.parseInt(tkns[4]);

                locations.add(loc1);
                locations.add(loc2);

                distances.putIfAbsent(loc1, new HashMap<>());
                distances.get(loc1).put(loc2, dist);

                distances.putIfAbsent(loc2, new HashMap<>());
                distances.get(loc2).put(loc1, dist);
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

        

    }
}
