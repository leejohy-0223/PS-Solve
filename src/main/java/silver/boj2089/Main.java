package silver.boj2089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(-13 % -2); // -1
        System.out.println(-13 / -2); // 6

        System.out.println(-1 / -2); // 0
        System.out.println(-1 % -2); // -1

        System.out.println(1 / -2); // 0
        System.out.println(1 % -2); // 1

        while (N != 0) {
            if (N % 2 == -1) {
                sb.append((N % 2) + 2);
                N = (N / -2) + 1;
            }
            else {
                sb.append(N % -2);
                N = (N / -2);
            }
        }
        System.out.println(sb.reverse());
    }
}
