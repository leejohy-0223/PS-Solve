package gold.boj1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainRefDfs {
    static class Node {
        int now;
        int dist;

        public Node(int now, int dist) {
            this.now = now;
            this.dist = dist;
        }
    }
    static boolean[] chk;
    static int N, M;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            list.get(n1).add(new Node(n2, dis));
            list.get(n2).add(new Node(n1, dis));
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

        for (Node node : list.get(start)) {
            if (!chk[node.now]) {
                chk[node.now] = true;
                dfs(node.now, target, dist + node.dist);
            }
        }

    }
}
