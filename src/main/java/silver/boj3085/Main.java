package silver.boj3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static char[][] candy;
    static int max = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        candy = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                candy[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽과 교환
                if (j + 1 < n) {
                    // swap
                    swap(i, j, i, j + 1);

                    // 갱신
                    max = Math.max(max, connectSearch());

                    // re-swap
                    swap(i, j, i, j + 1);
                }

                // 아래와 교환
                if (i + 1 < n) {
                    // swap
                    swap(i, j, i + 1, j);

                    // 갱신
                    max = Math.max(max, connectSearch());

                    // re-swap
                    swap(i, j, i + 1, j);

                }

            }
        }
        System.out.println(max);
    }

    private static int connectSearch() {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candy[i][j] == candy[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) {
                    ans = cnt;
                }
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candy[j][i] == candy[j - 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) {
                    ans = cnt;
                }
            }
        }
        return ans;
    }

    private static void swap(int nx, int ny, int x, int y) {
        char tmp = candy[nx][ny];
        candy[nx][ny] = candy[x][y];
        candy[x][y] = tmp;
    }
}
