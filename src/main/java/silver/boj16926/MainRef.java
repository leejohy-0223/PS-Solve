package silver.boj16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {

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

        int NSize = N, MSize = M;
        for (int i = 0; i < groupValue; i++) {
            // 시작점 정의
            int x = i, y = i;
            int direction = 0; // 0 : 하, 1 : 우, 2 : 상, 3: 좌
            int NR = R;

            while (NR != 0) {
                switch (direction) {
                    case 0:
                        if (NR / (NSize - 1) > 1) {
                            x += (NSize - 1);
                            NR -= (NSize - 1);
                            direction = 1;
                        } else {
                            x += NR;
                            NR = 0;
                        }
                        break;
                    case 1:
                        if (NR / (MSize - 1) > 1) {
                            y += (MSize - 1);
                            NR -= (MSize - 1);
                            direction = 2;
                        } else {
                            y += NR;
                            NR = 0;
                        }
                        break;
                    case 2:
                        if (NR / (NSize - 1) > 1) {
                            x -= (NSize - 1);
                            NR -= (NSize - 1);
                            direction = 3;
                        } else {
                            x -= NR;
                            NR = 0;
                        }
                        break;
                    case 3:
                        if (NR / (MSize - 1) > 1) {
                            y -= (MSize - 1);
                            NR -= (MSize - 1);
                            direction = 0;
                        } else {
                            y -= NR;
                            NR = 0;
                        }
                        break;
                }
            }
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            NSize -= 2;
            MSize -= 2;
        }

    }
}
