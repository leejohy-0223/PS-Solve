package gold.boj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Node {
    int node;
    int distance;

    public Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class MainRef {

    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int v;
    static int max = 0;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                list.get(idx).add(new Node(node, distance));
                list.get(node).add(new Node(idx, distance));
            }
        }
        // 임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visited = new boolean[v + 1];
        visited[1] = true;
        dfs(1, 0);

        // 구해진 노드에서부터 가장 먼 노드까지의 길이를 구한다.
        visited = new boolean[v + 1];
        visited[node] = true;
        dfs(node, 0);

        System.out.println(max);

    }

    private static void dfs(int x, int dis) {

        if (max < dis) {
            node = x;
            max = dis;
        }

        for (Node dist : list.get(x)) {
            if (!visited[dist.node]) {
                visited[dist.node] = true;
                dfs(dist.node, dis + dist.distance);
            }
        }
    }
}
