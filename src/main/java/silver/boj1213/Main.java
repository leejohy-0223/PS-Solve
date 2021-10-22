package silver.boj1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] alphabet = new int[26]; // 0 ~ 25(A - Z)

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 65]++;
        }

        if (s.length() == 1) {
            System.out.println(s);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 1) {
                int n = alphabet[i] / 2;
                for (int j = 0; j < n; j++) {
                    sb.append((char) (i + 65));
                }
                // 1보다 많은 홀수라면, 1로 변경
                if (alphabet[i] % 2 != 0) {
                    alphabet[i] = 1;
                    continue;
                }
                // 짝수라면 0처리 후 0으로 변경
                alphabet[i] = 0;
            }
        }

        String copy = sb.toString();
        String reverse = sb.reverse().toString();

        sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 1) {
                sb.append((char) (i + 65));
            }
        }

        String result = copy + sb + reverse;
        System.out.println("copy = " + copy);
        System.out.println("sb = " + sb);
        System.out.println("reverse = " + reverse);

        if (result.length() != s.length() || !checkSide(result)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        System.out.println(copy + sb + reverse);

    }

    private static boolean checkSide(String result) {
        int i = result.length() / 2;
        // 짝수
        if (result.length() % 2 == 0) {
            return (result.charAt(i - 1) == result.charAt(i));
        } else // 홀수
            return (result.charAt(i - 1) == result.charAt(i + 1));

    }
}
