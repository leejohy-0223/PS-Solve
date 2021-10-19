package bronze.boj10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];

        // init
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                arr[i][j] = ' ';
            }
        }

        for (int i = 0; i < 5; i++) {
            String tmp = br.readLine();
            int l = tmp.length();
            for (int j = 0; j < 15; j++) {
                if (l == 0) break;
                arr[i][j] = tmp.charAt(j);
                l--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != ' ') {
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
