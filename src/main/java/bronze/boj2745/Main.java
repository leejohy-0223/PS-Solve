package bronze.boj2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] chars = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());

        long result = 0;
        long idx = chars.length - 1;

        for (int i = 0; i < chars.length; i++) {
            int tmp = chars[i];

            if(tmp > 64) { // 알파벳이면 빼기, 즉 A(65) -> 65 - 55 = 10(dec)으로 변환
                tmp -= 55;
            } else
                tmp -= 48; // 알파벳 아니면, 숫자이므로 48 빼기, 즉 1(49) -> 49 - 48 = 1(dec)로 변환

            long product = 1;
            for (int j = 0; j < idx; j++) {
                product *= B;
            }
            result += (tmp * product);
            idx --;
        }
        System.out.println(result);

    }
}
