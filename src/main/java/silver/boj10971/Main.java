package silver.boj10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] dist;
    static int[] tmp;
    static boolean[] chk;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        tmp = new int[N + 1];
        chk = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(min);
    }

    private static void DFS(int L) {
        if(L == N) {
            tmp[L] = tmp[0];
            //로직 수행
            tsp(tmp);
            return;
        }
        for(int i=0; i<N; i++) {
            if(!chk[i]) {
                chk[i] = true;
                tmp[L] = i+1;
                DFS(L + 1);
                chk[i] = false;
            }
        }
    }

    private static void tsp(int[] tmp) {
        int sum = 0;

        for (int i = 1; i <tmp.length ; i++) {
            if(dist[tmp[i]][tmp[i-1]] == 0) {
                return;
            }
            sum += dist[tmp[i]][tmp[i-1]];
        }
        min = Math.min(min, sum);
    }
}
