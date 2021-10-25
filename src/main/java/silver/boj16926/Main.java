package silver.boj16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0, 1, 0, -1}; // 우, 상, 좌, 하
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 높이 크기
        int M = Integer.parseInt(st.nextToken()); // 너비 크기
        int R = Integer.parseInt(st.nextToken()); // 회전 수

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 돌려야 하는 그룹 개수
        int groupValue = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < groupValue; j++) {
                int x = j, y = j;

                int temp = arr[j][j];

                int k = 0;
                while (k < 4) {
                    int nx = dx[k] + x;
                    int ny = dy[k] + y;
                    if (nx >= j && ny >= j && nx < N - j && ny < M - j) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        k++; // 방향 변경
                    }
                }
                arr[j + 1][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
