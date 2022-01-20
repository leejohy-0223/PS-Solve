package silver.boj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] stairs;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        // System.out.println(topDown(N));
        bottomUp(N);
        System.out.println(dp[N]);
    }

    // top-down (재귀 사용)
    private static int topDown(int num) {
        // null일 경우 비워져 있는 값으로 판단할 수 있다. int로 하면 기본 0이기 때문에 이게 진짜 0이 들어있다는 건지 헷갈리게 된다.
        if (dp[num] == null) {
            dp[num] = Math.max(topDown(num - 2), topDown(num - 3) + stairs[num - 1]) + stairs[num];
        }
        return dp[num];
    }

    // bottom-up (반복문 사용)
    private static void bottomUp(int N) {
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
    }
}
