import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        Map<String, Map<String, Integer>> happiness = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                String name = info[0];
                int score = info[2].equals("gain") ? Integer.parseInt(info[3]) : -Integer.parseInt(info[3]);
                String neighbor = info[info.length - 1].replace(".", "");

                happiness.putIfAbsent(name, new HashMap<>());
                happiness.get(name).put(neighbor, score);
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

        long maxHappiness = getMaxHappiness(happiness);
        System.out.println("Part 1: " + maxHappiness);

        addSelf(happiness, "Cl1ngz");
        maxHappiness = getMaxHappiness(happiness);
        System.out.println("Part 2: " + maxHappiness);

    }

    private static void addSelf(Map<String, Map<String, Integer>> happiness, String self) {
        for (String person : happiness.keySet()) {
            happiness.get(person).put(self, 0);
        }
        Map<String, Integer> selfMap = new HashMap<>();
        for (String person : happiness.keySet()) {
            selfMap.put(person, 0);
        }
        happiness.put(self, selfMap);
    }

    static long getMaxHappiness(Map<String, Map<String, Integer>> happiness) {
        List<String> people = new ArrayList<>(happiness.keySet());

        // Reduce duplicate rotations.
        String fixedPerson = people.getFirst();
        people.removeFirst();

        List<List<String>> permutations = new ArrayList<>();
        generatePermutations(people, 0, permutations);
//        System.out.println(permutations);

        //  Check each arrangement
        long maxHappiness = Long.MIN_VALUE;
        for (List<String> perm : permutations) {
            List<String> arrangement = new ArrayList<>();
            arrangement.add(fixedPerson);
            arrangement.addAll(perm);
            long total = calculateHappiness(arrangement, happiness);
            if (total > maxHappiness) {
                maxHappiness = total;
            }
        }
        return maxHappiness;
    }

    static long calculateHappiness(List<String> arrangement, Map<String, Map<String, Integer>> happiness) {
        long total = 0;
        int n = arrangement.size();
        for (int i = 0; i < n; i++) {
            String person = arrangement.get(i);
            // if  i==0  left neighbor is the last person n-1.
            String leftNeighbor = arrangement.get((i == 0) ? n - 1 : i - 1);
            // if i is the last index then the right neighbor is the first person.
            String rightNeighbor = arrangement.get((i == n - 1) ? 0 : i + 1);
            total += happiness.get(person).get(leftNeighbor);
            total += happiness.get(person).get(rightNeighbor);
        }
        return total;
    }

    static void generatePermutations(List<String> list, int start, List<List<String>> result) {
        // 2==2 return new []
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            generatePermutations(list, start + 1, result); // generate permutations for the rest.
            Collections.swap(list, start, i); // Swap back (backtracking) - restore the original order.
        }
    }
}

