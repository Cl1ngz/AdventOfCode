import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    public static void main(String[] args) {
        try {
            String filepath = "../input.txt";
            String content = new String(Files.readAllBytes(Paths.get(filepath)));

            Pattern pattern = Pattern.compile("-?\\d+");
            Matcher matcher = pattern.matcher(content);

            int sum = 0;
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }

            System.out.println("Sum: " + sum);

        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}
