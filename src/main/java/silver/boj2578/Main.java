package silver.boj2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] chk = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[5][5];

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cur = 1;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int check = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (arr[k][l] == check) {
                            chk[k][l] = true;
                        }
                    }
                }

                int bingo = 0;
                // 하나 들어올 때마다 12번 반복해야 함
                // 1. -> 방향
                for (int k = 0; k < 5; k++) {
                    int cnt = 0;
                    for (int l = 0; l < 5; l++) {
                        if (chk[k][l]) {
                            cnt++;
                        }
                    }
                    if (cnt == 5) bingo++;
                }

                // 2. 아래 방향
                for (int k = 0; k < 5; k++) {
                    int cnt = 0;
                    for (int l = 0; l < 5; l++) {
                        if (chk[l][k]) {
                            cnt++;
                        }
                    }
                    if (cnt == 5) bingo++;
                }

                // 3. 대각 방향
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (chk[k][k]) {
                        cnt++;
                    }
                }
                if (cnt == 5) bingo++;

                cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (chk[4 - k][k]) {
                        cnt++;
                    }
                }
                if (cnt == 5) bingo++;

                if (bingo >= 3) {
                    System.out.println(cur);
                    return;
                }
                cur++;
            }
        }
    }
}
