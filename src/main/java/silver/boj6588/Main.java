package silver.boj6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] prime = new boolean[1000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // true = 소수
        prime[1] = false;

        for (int i = 2; i <= 1000000; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                prime[i] = true;
            }
        }

        while (n != 0) {
            boolean chk = false;
            for (int i = 3; i <= n-2; i+=2) {
                if(prime[i]) {
                    int temp = n - i;
                    if(!prime[temp]) {
                        continue;
                    }
                    sb.append(n).append(" = ").append(i).append(" + ").append(temp).append("\n");
                    chk = true;
                    break;
                }
            }
            if(!chk) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
