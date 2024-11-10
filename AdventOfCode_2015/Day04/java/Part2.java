import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Part2 {
    public static void main(String[] args) {
        String secret_key = "ckczppom";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            int number = 1;
            while (true) {
                String input = secret_key + number;
                byte[] hashBytes = md.digest(input.getBytes()); // MD5 Hash
                if (startsWithFiveZeros(hashBytes)) {
                    System.out.println(number);
                    break;
                }
                number++;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean startsWithFiveZeros(byte[] hashBytes) {
        return (hashBytes[0] == 0) && (hashBytes[1] == 0) && ((hashBytes[2]) == 0);
    }

}
