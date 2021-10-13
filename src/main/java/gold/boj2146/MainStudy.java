package gold.boj2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MainStudy {

    static int[][] arr;
    static Queue<Position> queue;
    static int N;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        marking(); // 각 섬들 군집을 숫자로 모두 변경함(2부터 오름차순으로)

        // 모든 노드에 대해서 BFS를 진행한다. 만약 BFS 중, 처음 start 섬과 다른 숫자가 나온다면 depth를 반환 & 최솟값으로 갱신한다.
        // queue에 넣을 때, 0만 넣는다.

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(arr[i][j] == 0) continue;

                visited = new boolean[N][N];
                int depth = BFS(i, j);

                if(depth == -1) continue;

                result = Math.min(result, depth);
            }
        }
        System.out.println(result);
    }

    private static int BFS(int i, int j) {
        int depth = -1;
        queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Position now = queue.poll();

                if (arr[now.x][now.y] != 0 && arr[now.x][now.y] != arr[i][j]) {
                    return depth;
                }

                for (int l = 0; l < 4; l++) {
                    int nx = now.x + dx[l];
                    int ny = now.y + dy[l];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(arr[nx][ny] == arr[i][j] || visited[nx][ny]) continue;

                    queue.offer(new Position(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            depth++;
        }
        return -1; // 만약 depth 0 혹은 1 등의 작은 숫자까지만 가고 여기서 반환되는거라면 정상적으로 shortest path를 찾은게 아니다. 따라서 -1을 반환한다.
    }

    private static void marking() {
        int num = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 0이거나 방문한 노드라면 marking 필요 없음
                if(arr[i][j] == 0 || visited[i][j]) continue;

                queue = new LinkedList<>();
                queue.offer(new Position(i, j));
                visited[i][j] = true;
                arr[i][j] = num;

                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        Position now = queue.poll();

                        for (int l = 0; l < 4; l++) {
                            int nx = now.x + dx[l];
                            int ny = now.y + dy[l];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(arr[nx][ny] == 0 || visited[nx][ny]) continue;

                            arr[nx][ny] = num;
                            queue.offer(new Position(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
                num++;
            }
        }
    }
}
