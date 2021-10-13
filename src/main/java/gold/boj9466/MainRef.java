package gold.boj9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {

    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited; // 단순히 방문했는지?
    static boolean[] finished; // 해당 노드에서 싸이클을 뽑았는지?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int now) {
        if(visited[now]) {
            return;
        }

        visited[now] = true;
        int next = arr[now];

        if(!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) { // 방문했다면, 해당 노드에서 사이클을 형성한적이 있는지?
                // 노드가 끝나려면 무조건 사이클을 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for (int i = next; i != now; i = arr[i]) {
                    count++;
                }
            }
        }
        // 작업 끝나면 더 이상 사용하지 않는다.
        finished[next] = true;
    }
}
