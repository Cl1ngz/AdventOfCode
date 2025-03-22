import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Part2 {
    public static void main(String[] args) {
        try {
            String filepath = "../input.txt";
            String content = new String(Files.readAllBytes(Paths.get(filepath)));

            JSONTokener tokener = new JSONTokener(content);
            Object json = tokener.nextValue();

            long sum = sumNumbers(json);
            System.out.println(sum);
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }

    private static long sumNumbers(Object json) {
        switch (json) {
            case JSONObject obj -> {
                for (String key : obj.keySet()) {
                    Object value = obj.get(key);
                    if ("red".equals(value)) {
                        return 0;
                    }
                }
                long sum = 0;
                for (String key : obj.keySet()) {
                    sum += sumNumbers(obj.get(key));
                }
                return sum;
            }
            case JSONArray arr -> {
                long sum = 0;
                for (int i = 0; i < arr.length(); i++) {
                    sum += sumNumbers(arr.get(i));
                }
                return sum;
            }
            case Number number -> {
                return number.longValue();
            }
            case null, default -> {
                return 0;
            }
        }
    }
}
