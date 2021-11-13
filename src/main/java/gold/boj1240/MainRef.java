package gold.boj1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainRef {
    static int N;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, end)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int start, int end) {
        visit = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        visit[start] = true;

        int dist = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.next == end) {
                dist = poll.dist;
                break;
            }
            for (Node node : list.get(poll.next)) {
                if (visit[node.next]) continue;
                visit[node.next] = true;
                queue.offer(new Node(node.next, poll.dist + node.dist));
            }
        }
        return dist;
    }
}

class Node {
    int next;
    int dist;

    public Node(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }
}

