package silver.boj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int tomato;
    static int m, n;
    static int depth = 0;
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        tomato = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    tomato++;
                }
                if(arr[i][j] == 1) {
                    queue.offer(new Position(i, j));
                }
            }
        }

        BFS();

        if (tomato != 0) {
            System.out.println(-1);
        } else
            System.out.println(depth - 1);

    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Position poll = queue.poll();
                for (int l = 0; l < 4; l++) {
                    int nx = dx[l] + poll.x;
                    int ny = dy[l] + poll.y;

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        tomato--;
                        queue.offer(new Position(nx, ny));
                    }
                }
            }
            depth++;
        }
    }
}
