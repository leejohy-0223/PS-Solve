package silver.boj1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
            return;
        }
        int count = 99;

        for (int i = 100; i <= N; i++) {
            int first = i % 10;
            int second = (i / 10) % 10;
            int third = (i / 100) % 10;

            if (second - first == third - second) {
                count++;
            }
        }
        if(N == 1000) {
            count--;
        }
        System.out.println(count);
    }
}
