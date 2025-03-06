import java.util.HashMap;
import java.util.Map;

public class CircuitSolver {
    private final Map<String, String> instructions;
    private final Map<String, Integer> memo; // store computed values

    public CircuitSolver(Map<String, String> instructions) {
        this.instructions = instructions;
        this.memo = new HashMap<>();
    }

    public int evaluate(String wire) {
        if (isNumeric(wire)) {
            return Integer.parseInt(wire) & 0xFFFF;
        }

        if (memo.containsKey(wire)) {
            return memo.get(wire);
        }

        String expr = instructions.get(wire);
        int result = 0;
        String[] tokens = expr.split(" ");


        if (tokens.length == 1) {
            result = evaluate(tokens[0]);
        } else if (tokens.length == 2) {
            // NOT x
            int operand = evaluate(tokens[1]);
            result = ~operand;
        } else if (tokens.length == 3) {
            // | x AND y | x OR y | x LSHIFT y | x RSHIFT y |
            int left = evaluate(tokens[0]);
            int right = evaluate(tokens[2]);

            result = switch (tokens[1]) {
                case "AND" -> left & right;
                case "OR" -> left | right;
                case "LSHIFT" -> left << right;
                case "RSHIFT" -> left >> right;
                default -> throw new IllegalArgumentException("Unknown operator: " + tokens[1]);
            };
        }

        result = result & 0xFFFF;
        memo.put(wire, result);
        return result;
    }

    private boolean isNumeric(String wire) {
        for (char c : wire.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}

