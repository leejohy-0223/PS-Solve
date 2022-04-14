package barkingDog.BFS0x09.boj2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static boolean[][] board;
    static List<Integer> list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] value = br.readLine().split(" ");
        M = Integer.parseInt(value[0]);
        N = Integer.parseInt(value[1]);
        int K = Integer.parseInt(value[2]);

        board = new boolean[M][N];

        while (K-- > 0) {
            String[] split = br.readLine().split(" ");
            int lx = Integer.parseInt(split[0]);
            int ly = Integer.parseInt(split[1]);
            int rx = Integer.parseInt(split[2]);
            int ry = Integer.parseInt(split[3]);

            for (int i = lx; i < rx; i++) {
                for (int j = ly; j < ry; j++) {
                    board[j][i] = true;
                }
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!board[i][j]) {
                    board[i][j] = true;
                    BFS(i, j);
                }
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }

    private static void BFS(int i, int j) {
        int size = 1;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(i, j));

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = poll.x + dx[k];
                int ny = poll.y + dy[k];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !board[nx][ny]) {
                    board[nx][ny] = true;
                    size++;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }
        list.add(size);
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
