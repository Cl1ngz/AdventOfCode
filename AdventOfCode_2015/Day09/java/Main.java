import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
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

        List<String> locList = new ArrayList<>(locations);
        List<List<String>> perms = generatePermutations(locList);

        // track minimum distance and maximum distance
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        for (List<String> route : perms) {
            int routeDistance = calculateRouteDistance(route, distances);
            if (routeDistance < minDist) {
                minDist = routeDistance;
            }
            if (routeDistance > maxDist) {
                maxDist = routeDistance;
            }
        }

        System.out.println("Part 1:");
        System.out.println("Shortest route: " + minDist);
        System.out.println("-".repeat(30));
        System.out.println("Part 2:");
        System.out.println("Longest route: " + maxDist);
    }

    private static int calculateRouteDistance(List<String> route, Map<String, Map<String, Integer>> distances) {
        int sum = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            sum += distances.get(route.get(i)).get(route.get(i + 1));
        }

        return sum;
    }

    // all permutation list of lists
    private static List<List<String>> generatePermutations(List<String> list) {
        List<List<String>> result = new ArrayList<>();
        permute(list, 0, result);
        return result;
    }

    private static void permute(List<String> list, int start, List<List<String>> result) {
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < list.size(); i++) {
                Collections.swap(list, i, start);
                permute(list, start + 1, result);
                Collections.swap(list, start, i);
            }
        }
    }
}