package barkingDog.BFS0x09.boj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int maxX;
    static int maxY;

    static boolean[][] fireChk;
    static boolean[][] posChk;
    static Queue<Position> firePos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);

            maxX = h;
            maxY = w;

            char[][] board = new char[h][w];
            fireChk = new boolean[h][w];
            posChk = new boolean[h][w];
            firePos = new LinkedList<>();

            int manX = 0;
            int manY = 0;

            for (int i = 0; i < h; i++) {
                char[] chars = br.readLine().toCharArray();

                for (int j = 0; j < w; j++) {
                    board[i][j] = chars[j];
                    if (chars[j] == '*') {
                        fireChk[i][j] = true;
                        firePos.add(new Position(i, j));
                        continue;
                    }
                    if (chars[j] == '@') {
                        manX = i;
                        manY = j;
                    }
                }
            }
            sb.append(BFS(board, manX, manY, w, h)).append("\n");
        }
        System.out.println(sb);
    }

    private static String BFS(char[][] board, int manX, int manY, int w, int h) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(manX, manY));
        posChk[manX][manY] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 불을 한번 움직이기
            fireBFS(board);
            result++;
            for (int i = 0; i < size; i++) {
                Position poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];

                    // 탈출 조건
                    if (nx >= h || nx < 0 || ny >= w || ny < 0) {
                        return String.valueOf(result);
                    }

                    // 갈 수 있는 경로일 때만 추가
                    if (!posChk[nx][ny] && board[nx][ny] == '.') {
                        posChk[nx][ny] = true;
                        queue.offer(new Position(nx, ny));
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static void fireBFS(char[][] board) {
        int size = firePos.size();
        for (int i = 0; i < size; i++) {
            Position pos = firePos.poll();
            for (int j = 0; j < 4; j++) {
                int nx = pos.x + dx[j];
                int ny = pos.y + dy[j];

                if (nx >= maxX || nx < 0 || ny >= maxY || ny < 0 || fireChk[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == '.' || board[nx][ny] == '@') {
                    board[nx][ny] = '*';
                    fireChk[nx][ny] = true;
                    firePos.add(new Position(nx, ny));
                }
            }
        }
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
