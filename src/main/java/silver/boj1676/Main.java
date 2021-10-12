package silver.boj1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                result++;
            }
            if (N % 25 == 0) {
                result++;
            }
            if (N % 125 == 0) {
                result++;
            }
            N--;
        }
        System.out.println(result);
    }
}
