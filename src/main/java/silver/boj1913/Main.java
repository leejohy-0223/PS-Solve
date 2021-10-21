package silver.boj1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int copy = N;
        int[][] arr = new int[N][N];

        int x = 0;
        int y = 0;
        int value = N * N;
        StringBuilder sb = new StringBuilder();

        while (N != 1) {

            // 1. 아래방향
            for (int i = x; i <= x + N - 1; i++) {
                arr[i][y] = value--;
            }

            // 2. -> 방향
            for (int i = y + 1; i <= y + N - 1; i++) {
                arr[x + N - 1][i] = value--;
            }

            // 3. 위 방향
            for (int i = x + N - 2; i >= x; i--) {
                arr[i][y + N - 1] = value--;
            }

            // 4. <- 방향
            for (int i = y + N - 2; i > y; i--) {
                arr[x][i] = value--;
            }

            x += 1;
            y += 1;
            N -= 2;
        }
        arr[x][y] = 1;
        int kx = 0, ky = 0;
        for (int i = 0; i < copy; i++) {
            for (int j = 0; j < copy; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == k) {
                    kx = i + 1;
                    ky = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(kx).append(" ").append(ky);
        System.out.println(sb);
    }
}
