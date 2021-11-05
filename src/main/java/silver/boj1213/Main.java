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

        // 홀수 개수 counting
        int odd = 0;

        for (int i : alphabet) {
            if (i % 2 != 0) {
                odd++;
            }
        }
        System.out.println(odd);

        // 홀수가 2개 이상이면 return
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 이 시점에는 짝수 여러개, 홀수 하나만 남아야 한다.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if(alphabet[i] == 0) continue;

            // 짝수라면 반절만 사용하고 0으로 모두 변경
            if (alphabet[i] % 2 == 0) {
                int half = alphabet[i] / 2;
                for (int j = 0; j < half; j++) {
                    sb.append((char) (i + 65));
                }
                alphabet[i] = 0;
                continue;
            }

            // 홀수라면 반절 사용하고 1로 변경
            // 수가 1이라면 그냥 pass
            if (alphabet[i] == 1) continue;

            int half = alphabet[i] / 2;
            for (int j = 0; j < half; j++) {
                sb.append((char) (i + 65));
            }
            alphabet[i] = 1;
        }

        StringBuilder tmp = new StringBuilder(sb.toString());
        // 먼저 뒤집은 놈 만들기
        StringBuilder reverse = sb.reverse();

        // 기존 만들어진거에 홀수 붙이기
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 1) {
                tmp.append((char) (i + 65));
            }
        }

        // 최종 모두 붙이기
        tmp.append(reverse);
        System.out.println(tmp);
    }
}
