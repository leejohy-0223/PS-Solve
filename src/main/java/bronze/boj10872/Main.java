package bronze.boj10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] mem = new int[13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    private static int factorial(int n) {

        mem[0] = 1;
        mem[1] = 1;

        for (int i = 2; i <= n; i++) {
            mem[i] = i * mem[i - 1];
        }
        return mem[n];
    }
}
