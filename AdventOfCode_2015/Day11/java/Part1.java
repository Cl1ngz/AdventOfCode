import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Part1 {
    public static void main(String[] args) {
        // 8 lowercase
        //incrementing old until it valid
        // if it was z -> its now a
        // must include one increasing straight of at least three letters, like abc, bcd, cde, and so on, up to xyz. They cannot skip letters; abd doesn't count.
        //  not contain the letters i, o, or l
        //  contain at least two different, non-overlapping pairs of letters, like aa, bb, or zz.

        String input = "vzbxkghb";
        String newPass = incrementUntilValid(input);

        System.out.println("New pass: " + newPass);
    }

    private static String incrementUntilValid(String s) {
        String newPass = s;
        while (!isValid(newPass)) {
            newPass = increment(newPass);
        }
        return newPass;
    }

    private static String increment(String s) {
        char[] pass = s.toCharArray();
        int pos = pass.length - 1;
        while (pos >= 0) {
            if (pass[pos] == 'z') {
                pass[pos] = 'a';
                pos--;
            } else {
                pass[pos]++;
                break;
            }
        }
        return new String(pass);
    }

    private static boolean isValid(String s) {
        if (s.contains("i") || s.contains("o") || s.contains("l")) {
            return false;
        }

        return hasTwoDifferentNonOverlappingPairs(s) && hasIncreasingStraight(s);
    }

    public static boolean hasTwoDifferentNonOverlappingPairs(String s) {
        Set<Character> pairs = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                pairs.add(s.charAt(i));
                i++;
            }
        }
        return pairs.size() >= 2;
    }

    public static boolean hasIncreasingStraight(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            char third = s.charAt(i + 2);

            if (first + 1 == second && second + 1 == third) {
                return true;
            }
        }
        return false;
    }
}
