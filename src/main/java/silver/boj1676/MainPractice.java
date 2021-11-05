package silver.boj1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        if (N >= 5) {
            result += N / 5;
        }
        if (N >= 25) {
            result += N / 25;
        }
        if (N >= 125) {
            result += N / 125;
        }

        System.out.println(result);

    }
}
