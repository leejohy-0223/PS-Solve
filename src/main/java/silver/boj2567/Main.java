package silver.boj2567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] board = new boolean[101][101]; // black = true, white = false
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (!board[i][j]) {
                        board[i][j] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(!board[i][j]) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
                        if (!board[nx][ny]) {
                            result ++;
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
}
