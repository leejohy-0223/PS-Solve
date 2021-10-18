package silver.boj10971;

import java.io.*;
import java.util.*;

public class MainDp {
    static BufferedReader br;
    static StringTokenizer st;

    static int[][] dist = new int[20][20];
    static int[][] dp = new int[10][1 << 11]; // dp = new int[10][2048];
    static int n, sum, ans, INF = (int) 1e8;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(f(0, 1));
    }

    static int f(int cur, int mask) {
        if (~dp[cur][mask] != 0) return dp[cur][mask];
        if (1 << n == mask + 1) {
            if (dist[cur][0] != 0) return dist[cur][0];
            else return INF;
        }
        dp[cur][mask] = INF;

        for (int i = 1; i < n; i++) {
            if ((mask & 1 << i) == 0 && dist[cur][i] != 0) {
                dp[cur][mask] = Math.min(f(i, mask | 1 << i) + dist[cur][i], dp[cur][mask]);
            }
        }
        return dp[cur][mask];
    }
}
