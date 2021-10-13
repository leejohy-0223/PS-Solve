package silver.boj10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] chk;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            count = 0;
            chk = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!chk[i]) {
                    count++;
                    chk[i] = true;
                    BFS(i);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int node = arr[poll];

            if (!chk[node]) {
                chk[node] = true;
                queue.offer(node);
            }
        }
    }
}
