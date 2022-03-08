package barkingDog.BFS0x09.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0));
        board[0][0] = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + poll.x;
                    int ny = dy[j] + poll.y;

                    if (nx == N - 1 && ny == M - 1) {
                        System.out.println(++result);
                        return;
                    }

                    if (nx < N && nx >= 0 & ny < M && ny >= 0 && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
