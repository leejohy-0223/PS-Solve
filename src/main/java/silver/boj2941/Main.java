package silver.boj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int result = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && (s.charAt(i) == 'c' || s.charAt(i) == 's' || s.charAt(i) == 'z')) {
                if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                    result++;
                    i += 2;
                    continue;
                }
            }
            if (s.charAt(i) == 'd' && i + 1 < s.length()) {
                if (s.charAt(i + 1) == '-') {
                    result++;
                    i += 2;
                    continue;
                }
            }
            if (s.charAt(i) == 'd' && i + 2 < s.length()) {
                if (s.substring(i + 1, i + 3).equals("z=")) {
                    result++;
                    i += 3;
                    continue;
                }
            }
            if (i + 1 < s.length() && (s.charAt(i) == 'l' || s.charAt(i) == 'n')) {
                if (s.charAt(i + 1) == 'j') {
                    result++;
                    i += 2;
                    continue;
                }
            }
            result++;
            i++;
        }
        System.out.println(result);
    }
}
