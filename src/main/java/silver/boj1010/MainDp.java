package silver.boj1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDp {

    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n, m = 0;

        for(int i=0; i<31; i++) {
            dp[i][i] = dp[i][0] = 1;
        }

        for(int i=2; i<31; i++) {
            for(int j=1; j<i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n] + "\n");
        }
        System.out.println(sb);
    }
}
