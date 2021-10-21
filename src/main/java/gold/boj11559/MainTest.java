package gold.boj11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {

    static char[][] board = new char[12][6];
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                board[i][j] = chars[j];
            }
        }

        while (true) {
            boolean chk = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] != '.') {
                        visited = new boolean[12][6];
                        if (dfs(i, j) >= 4) { // dfs의 결과로, 4개 이상의 그룹이 발견되었다면 터뜨리고 chk를 true로 반영
                            pop();
                            chk = true;
                        }
                    }
                }
            }
            if (chk) { // 결과로 폭발이 일어났었다면 result를 올리고 rebuild 진행
                result++;
                rebuild();
            } else
                break;
        }
        System.out.println(result);
    }

    private static void rebuild() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (board[i][j] != '.') {
                    for (int k = i; k < 11; k++) {
                        if (board[k + 1][j] != '.') break;
                        board[k + 1][j] = board[k][j];
                        board[k][j] = '.';
                    }
                }
            }
        }
    }

    private static void pop() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visited[i][j]) {
                    board[i][j] = '.';
                }
            }
        }
    }

    private static int dfs(int i, int j) {

        visited[i][j] = true;
        int count = 1;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && board[nx][ny] == board[i][j]) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }
}
