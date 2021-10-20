package gold.boj11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static boolean[][] colorVisited;

    static char[][] board = new char[12][6];
    static int result = 0;
    static boolean finalCheck = false;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                board[i][j] = chars[j];
            }
        }

        while (true) {
            finalCheck = false;
            result++;
            executer();

            // executer 실행후에 finalCheck가 true라면, 다시 executer를 실행해야한다.
            if (!finalCheck) {
                break;
            }
        }

        // 빠져나왔으면 마지막 result는 의미 없음
        System.out.println(result - 1);

    }

    private static void executer() {
        // dfs 실행
        breakBlock();
        // 블록 세팅
        setBlock();
    }

    private static void breakBlock() {
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.') {
                    visited = new boolean[12][6];
                    visited[i][j] = true;
                    count = 1;
                    dfs(i, j, board[i][j]);
                }
            }
        }
    }

    private static void dfs(int i, int j, char color) {
        // count가 4개 이상이라면 모두 .으로 바꾸는 과정 수행
        if (count >= 4) {
            finalCheck = true;
            colorVisited = new boolean[12][6];
            zeroDfs(i, j, color);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;

            if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || board[nx][ny] == '.' || board[nx][ny] != color || visited[nx][ny])
                continue;
            visited[nx][ny] = true;
            count ++;
            dfs(nx, ny, color);
        }

    }

    private static void zeroDfs(int i, int j, char color) {
        board[i][j] = '.';
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;

            if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || board[nx][ny] == '.' || colorVisited[nx][ny] || board[nx][ny] != color)
                continue;

            colorVisited[nx][ny] = true;
            board[nx][ny] = '.';
            zeroDfs(nx, ny, color);
        }
    }


    private static void setBlock() {
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 11; j >= 0; j--) {
                if (board[j][i] != '.') {
                    sb.append(board[j][i]);
                }
            }
            int idx = 0;

            // 있는 것 먼저 몰기
            for (int j = 11; j >= (12 - sb.length()); j--) {
                String s = sb.toString();
                board[j][i] = s.charAt(idx);
                idx++;
            }

            // 나머지 .으로 채우기
            for (int j = (12 - sb.length()) - 1; j >= 0; j--) {
                board[j][i] = '.';
            }
        }
    }
}
