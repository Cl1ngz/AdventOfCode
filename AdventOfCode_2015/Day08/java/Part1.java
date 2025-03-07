import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part1 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        int totalCodeLength = 0;
        int totalMemoryLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalCodeLength += line.length();

                int memLength = calculateMemoryLength(line);
                totalMemoryLength += memLength;
            }

        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

        System.out.println("Difference: " + (totalCodeLength - totalMemoryLength));
    }

    private static int calculateMemoryLength(String s) {
        String inner = s.substring(1, s.length() - 1);
        int count = 0;

        // character by character
        for (int i = 0; i < inner.length(); ) {
            char c = inner.charAt(i);

            if (c == '\\') {
                char next = inner.charAt(i + 1);
                if (next == '\\' || next == '"') {
                    i += 2;  // one character but 2 spaces ex: \\ or \"
                } else if (next == 'x') {
                    i += 4; // one character but 4 spaces ex: \x27
                } else {
                    i++;
                }

            } else {
                i++;
            }
            count++;
        }
        return count;
    }
}
