public class Main {
    public static void main(String[] args) {
        String input = "1321131112";

        System.out.println(ResultGenerator(input, 40));
        System.out.println(ResultGenerator(input, 50));
    }

    private static int ResultGenerator(String input, int iterations) {
        String result = input;
        for (int i = 0; i < iterations; i++) {
            result = lookAndSay(result);
        }

        return result.length();
    }

    private static String lookAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char digit = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == digit) {
                count++;
            } else {
                sb.append(count);
                sb.append(digit);
                digit = cur;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(digit);

        return sb.toString();
    }
}