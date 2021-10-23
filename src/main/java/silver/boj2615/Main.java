package silver.boj2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[19][19];

        StringTokenizer st;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] == 0) continue;

                int color = arr[i][j];

                // 오른쪽 & 아래 & 대각선 방향으로 각 나오면 검사 진행
                if (i + 4 < 19 || j + 4 < 19) {
                    if (checkLine(i, j, color)) {
                        System.out.println(color);
                        System.out.println(++i + " " + ++j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean checkLine(int i, int j, int color) {

        int count = 0;
        // 가로 방향 체크
        if(j + 4 < 19) {
            for (int l = j; l < j + 5; l++) {
                if (arr[i][l] != color) {
                    break;
                } else count++;
            }
            if (count == 5) {
                if (!((j - 1 >= 0 && arr[i][j - 1] == color) || (j + 5 < 19 && arr[i][j + 5] == color))) {
                    return true;
                }
            }
        }

        count = 0;
        // 세로 방향 체크
        if(i + 4 < 19) {
            for (int k = i; k < i + 5; k++) {
                if (arr[k][j] != color) {
                    break;
                } else count++;
            }
            // 6개 넘어가면 false
            if (count == 5) {
                if (!((i - 1 >= 0 && arr[i - 1][j] == color) || (i + 5 < 19 && arr[i + 5][j] == color))) {
                    return true;
                }
            }
        }

        count = 0;
        // 대각선 체크(오른쪽 아래 방향)
        if(i + 4 < 19 && j + 4 < 19) {
            for (int k = 0; k < 5; k++) {
                if (arr[i + k][j + k] != color) {
                    break;
                } else count++;
            }
            if (count == 5) {
                return !((i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] == color) || (i + 5 < 19 && j + 5 < 19 && arr[i + 5][j + 5] == color));
            }
        }

        count = 0;
        // 대각선 체크(오른쪽 위 방향)
        if(i - 4 >= 0 && j + 4 < 19) {
            for (int k = 0; k < 5; k++) {
                if (arr[i - k][j + k] != color) {
                    break;
                } else count++;
            }
            if (count == 5) {
                return !((i + 1 < 19 && j - 1 >= 0 && arr[i + 1][j - 1] == color) || (i - 5 >= 0 && j + 5 < 19 && arr[i - 5][j + 5] == color));
            }
        }
        return false;
    }
}
