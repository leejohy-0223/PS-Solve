package gold.boj11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRef {
    static int[] dx = { 0, -1, 0, 1 }, dy = { 1, 0, -1, 0 };
    static char[][] puyo = new char[12][6];
    static boolean[][] visit = new boolean[12][6];
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) { puyo[i][j] = input.charAt(j); }
        }

        while (true) {
            boolean flag = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (puyo[i][j] == '.') continue;
                    if (dfs(i, j) >= 4) { flag = true; pang(); } // 4개 이상이면 flag 변경 & 터뜨리기
                    visit = new boolean[12][6];
                }
            }

            if (flag) { COUNT++; down(); }
            else { break; }
        }
        System.out.println(COUNT);
    }

    public static int dfs(int x, int y) {
        visit[x][y] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int sx = x + dx[i], sy = y + dy[i];
            if (sx >= 0 && sx < 12 && sy >= 0 && sy < 6 && puyo[x][y] == puyo[sx][sy] && !visit[sx][sy]) {
                count += dfs(sx, sy);
            }
        }
        return count;
    }

    public static void pang() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visit[i][j]) puyo[i][j] = '.';
            }
        }
    }

    public static void down() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 5; j >= 0; j--) {
                if (puyo[i][j] == '.') continue;

                int index = i;
                while (true) {
                    if (index == 11 || puyo[index + 1][j] != '.') break;
                    puyo[index + 1][j] = puyo[index][j];
                    puyo[index][j] = '.';
                    index++;
                }
            }
        }
    }
}
