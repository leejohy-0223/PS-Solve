package gold.boj2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        labeling();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                visited = new boolean[N][N];
                visited[i][j] = true;
                int dist = BFS(i, j);

                if (dist == -1) continue;

                result = Math.min(result, dist);
            }
        }
        System.out.println(result);
    }

    private static void labeling() {
        int num = 2;
        Queue<Node> queue;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] == 0 || visited[i][j]) continue;
                queue = new LinkedList<>();
                queue.offer(new Node(i, j));
                visited[i][j] = true;
                arr[i][j] = num;

                while (!queue.isEmpty()) {
                    for (int k = 0; k < queue.size(); k++) {
                        Node poll = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = dx[l] + poll.x;
                            int ny = dy[l] + poll.y;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1 && !visited[nx][ny]) {
                                queue.offer(new Node(nx, ny));
                                arr[nx][ny] = num;
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
                num++;
            }
        }
    }

    private static int BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        int depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 확실히 분리시켜야한다.!!
            for (int k = 0; k < size; k++) {
                Node poll = queue.poll();

                if (arr[poll.x][poll.y] != 0 && arr[poll.x][poll.y] != arr[i][j]) { // 0이 아닌 새로운 노드(섬)이면 depth 리턴
                    return depth;
                }

                for (int l = 0; l < 4; l++) {
                    int nx = dx[l] + poll.x;
                    int ny = dy[l] + poll.y;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (arr[nx][ny] == arr[i][j] || visited[nx][ny]) continue; // 시작점과 같거나, 방문한 노드이면 continue

                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            depth++;
        }
        return -1; // depth를 위에서 리턴하지 못했다는건, 다른 섬을 못 만난 것이므로 -1을 리턴한다.
    }
}
