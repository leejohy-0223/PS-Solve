package barkingDog.BFS0x09.boj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int result = 0;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        board = new boolean[N][M];
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = !tmp[j].equals("0");
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] && !visited[i][j]) {
                    count++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(count);
        System.out.println(result);
    }

    private static void BFS(int i, int j) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(i, j));
        visited[i][j] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            Position tmp = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];
                if (nx < N && nx >= 0 && ny < M && ny >= 0 && board[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    board[nx][ny] = false;
                    size++;
                    queue.add(new Position(nx, ny));
                }
            }
        }
        result = Math.max(result, size);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
