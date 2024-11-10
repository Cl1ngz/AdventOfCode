import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part2 {
    public static void main(String[] args) {
        String filepath = "../input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            int[][] grid = new int[1000][1000];
            String line;
            while ((line = reader.readLine()) != null) {
                InstructionResult instruction = parseInstruction(line);
                applyInstruction(grid, instruction);
            }

            int totalBrightness = calculateTotalBrightness(grid);
            System.out.println("Total brightness of all lights: " + totalBrightness);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }

    private static InstructionResult parseInstruction(String line) {
        String[] inst = line.split(" ");
        int[] start;
        int[] end;

        if (inst[0].equals("toggle")) {
            start = parseCoordinates(inst[1]);
            end = parseCoordinates(inst[3]);
            return new InstructionResult(Instruction.TOGGLE, start, end);
        } else if (inst[1].equals("on")) {
            start = parseCoordinates(inst[2]);
            end = parseCoordinates(inst[4]);
            return new InstructionResult(Instruction.TURN_ON, start, end);
        } else if (inst[1].equals("off")) {
            start = parseCoordinates(inst[2]);
            end = parseCoordinates(inst[4]);
            return new InstructionResult(Instruction.TURN_OFF, start, end);
        }

        return null;
    }

    private static int[] parseCoordinates(String coordStr) {
        String[] coords = coordStr.split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        return new int[]{x, y};
    }

    private static void applyInstruction(int[][] grid, InstructionResult instruction) {
        int[] start = instruction.start();
        int[] end = instruction.end();

        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                switch (instruction.instruction()) {
                    case TOGGLE -> grid[i][j] += 2;
                    case TURN_ON -> grid[i][j] += 1;
                    case TURN_OFF -> {
                        grid[i][j] -= 1;
                        if (grid[i][j] < 0) {
                            grid[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    private static int calculateTotalBrightness(int[][] grid) {
        int total = 0;
        for (int[] row : grid) {
            for (int light : row) {
                total += light;
            }
        }
        return total;
    }
}