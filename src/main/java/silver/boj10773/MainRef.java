package silver.boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int size = 0;
        int[] stack = new int[n];

        while (n-- > 0) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                stack[size - 1] = 0;
                size--;
            } else {
                stack[size++] = cur;
            }
        }
        int sum = 0;
        for (int x : stack) {
            sum += x;
        }
        System.out.println(sum);

    }
}
