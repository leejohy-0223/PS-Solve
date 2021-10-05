package silver.boj2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int result = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = M; i<=N; i++) {
            if(isPrime(i)) {
                sum += i;
                result = Math.min(result, i);
            }
        }
        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(result);
        }

    }

    private static boolean isPrime(int num) {

        if(num == 1) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
