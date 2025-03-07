import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Part2 {
    public static void main(String[] args) {
        String filepath = "../input.txt";
        int totalCodeLength = 0;
        int totalEncodedLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalCodeLength += line.length();

                String encoded = encodeString(line);
                totalEncodedLength += encoded.length();

            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

        System.out.println("Difference: " + (totalEncodedLength - totalCodeLength));
    }

    private static String encodeString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('"');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '"' || c == '\\') {
                sb.append('\\');
            }
            sb.append(c);
        }

        sb.append('"');
        return sb.toString();
    }
}
