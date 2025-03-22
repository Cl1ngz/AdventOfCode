import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Part1Test {
    @Test
    public void testSampleInput() {
        // Sample input lines as given in the problem description.
        String[] lines = {
                "Alice would gain 54 happiness units by sitting next to Bob.",
                "Alice would lose 79 happiness units by sitting next to Carol.",
                "Alice would lose 2 happiness units by sitting next to David.",
                "Bob would gain 83 happiness units by sitting next to Alice.",
                "Bob would lose 7 happiness units by sitting next to Carol.",
                "Bob would lose 63 happiness units by sitting next to David.",
                "Carol would lose 62 happiness units by sitting next to Alice.",
                "Carol would gain 60 happiness units by sitting next to Bob.",
                "Carol would gain 55 happiness units by sitting next to David.",
                "David would gain 46 happiness units by sitting next to Alice.",
                "David would lose 7 happiness units by sitting next to Bob.",
                "David would gain 41 happiness units by sitting next to Carol."
        };

        // Build the happiness map.
        Map<String, Map<String, Integer>> happiness = new HashMap<>();
        for (String line : lines) {
            String[] info = line.split(" ");
            String person = info[0];
            int units = info[2].equals("gain") ? Integer.parseInt(info[3]) : -Integer.parseInt(info[3]);
            String neighbor = info[info.length - 1].replace(".", "");
            happiness.putIfAbsent(person, new HashMap<>());
            happiness.get(person).put(neighbor, units);
        }


        // Assert that the maximum total happiness is 330.
        assertEquals(330, Main.getMaxHappiness(happiness));
    }
}