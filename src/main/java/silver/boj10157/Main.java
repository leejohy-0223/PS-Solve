package silver.boj10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                arr[i][j] = 0;
            }
        }

        long k = Long.parseLong(br.readLine());
        int multiple = c * r;
        if (k > multiple) {
            System.out.println(0);
            return;
        }

        int c2 = c;
        int r2 = r;
        int x = 0;
        int y = 0;
        int start = 1;
        while (multiple >= start) {

            // -> 방향
            for (int i = y; i <= y + r2 - 1; i++) {
                arr[x][i] = start++;
            }

            // 아래 방향
            for (int i = x + 1; i <= x + c2 - 1; i++) {
                arr[i][y + r2 - 1] = start++;
            }

            // <- 방향
            for (int i = y + r2 - 2; i >= y; i--) {
                if(arr[x+c2-1][i] != 0) break;
                arr[x + c2 - 1][i] = start++;
            }

            // 위 방향
            for (int i = x + c2 - 2; i >= x + 1; i--) {
                if(arr[i][y] != 0) break;
                arr[i][y] = start++;
            }
            x++;
            y++;
            r2 -= 2;
            c2 -= 2;
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (arr[i][j] == k) {
                    System.out.print(i + 1);
                    System.out.print(" ");
                    System.out.println(j + 1);
                }
            }
        }


    }
}

