package silver.boj1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int value = 1000000;
    static boolean[] chk = new boolean[value + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        chk[1] = false;
        // chk가 true이면 소수
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                chk[i] = true;
            }
        }
        for (int i = M; i <= N; i++) {
            if (chk[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
