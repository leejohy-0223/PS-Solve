package gold.boj1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int node;
    int dist;

    public Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int N;
    static boolean[] visited;
    static int node;
    static int maxDist = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            list.get(parent).add(new Node(child, distance));
            list.get(child).add(new Node(parent, distance));
        }

        // 아무 노드 대상으로, 가장 먼 노드 찾기
        visited = new boolean[N + 1];
        visited[1] = true;
        DFS(1, 0);

        // 찾아진 노드를 대상으로, 거리를 가장 긴 거리로 갱신하기
        visited = new boolean[N + 1];
        visited[node] = true;
        DFS(node, 0);

        System.out.println(maxDist);

    }

    private static void DFS(int n, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            node = n;
        }

        for (Node cur : list.get(n)) {
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            DFS(cur.node, dist + cur.dist);
        }
    }
}
