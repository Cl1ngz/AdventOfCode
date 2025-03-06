import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        Map<String, String> instructions = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("->");
                String expression = parts[0].trim();
                String wire = parts[1].trim();
                instructions.put(wire, expression);
            }


        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

        CircuitSolver solver = new CircuitSolver(instructions);
        int signalA = solver.evaluate("a");

        System.out.println("-".repeat(50));
        System.out.println("Part one: ");
        System.out.println("Signal provided to wire a: " + signalA);
        System.out.println("-".repeat(50));

        instructions.put("b", Integer.toString(signalA));
        solver = new CircuitSolver(instructions);
        int newSignalA = solver.evaluate("a");
        System.out.println("-".repeat(50));
        System.out.println("Part two: ");
        System.out.println("New signal on wire a: " + newSignalA);
        System.out.println("-".repeat(50));
    }
}
