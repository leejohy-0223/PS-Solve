package silver.boj18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x, y, num, count;

    public Point(int x, int y, int num, int count) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Point other) {
        return this.num - other.num;
    }
}

public class MainRef {
    static int[][] data;
    static LinkedList<Point> pointList = new LinkedList<>();
    static Queue<Point> que;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, K, S, X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] != 0) pointList.add(new Point(i, j, data[i][j], 0));
            }
        }
        Collections.sort(pointList);
        que = pointList;
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(data[X][Y]);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Point p = que.poll();
            if (p.count == S) return;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > N || data[nx][ny] != 0) {
                    continue;
                }
                data[nx][ny] = p.num;
                que.add(new Point(nx, ny, p.num, p.count + 1));
            }
        }
    }
}
