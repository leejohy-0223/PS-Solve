package silver.boj5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[N + 1][N + 1];

        StringTokenizer str;
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            check[k][v] = check[v][k] = true;
        }

        boolean[] check2 = new boolean[N + 1];
        for (int i = 2; i <=  N; i++) {
            if (check[1][i]) {
                check2[i] = true;
                for (int j = 2; j <= N; j++) {
                    if (check[i][j]) {
                        check2[j] = true;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (check2[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
