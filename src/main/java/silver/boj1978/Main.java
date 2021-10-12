package silver.boj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (N-- > 0) {
            int tmp = Integer.parseInt(st.nextToken());

            // 소수인 경우 true, 아닌 경우 false
            boolean isPrime = true;
            if (tmp == 1) {
                continue;
            }

            for (int i = 2; i <= Math.sqrt(tmp); i++) {
                if (tmp % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count++;
        }
        System.out.println(count);
    }
}
