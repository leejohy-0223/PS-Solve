package gold.boj1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] chk;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            arr[n1][n2] = dis;
            arr[n2][n1] = dis;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            chk = new boolean[N + 1];
            chk[n1] = true;

            dfs(n1, n2, 0);

        }
        System.out.println(sb);
    }

    private static void dfs(int start, int target, int dist) {

        if (start == target) {
            sb.append(dist).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(chk[i] || arr[start][i] == 0) continue;
            chk[i] = true;
            dfs(i, target, dist + arr[start][i]);
        }
    }
}
