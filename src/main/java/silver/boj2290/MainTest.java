package silver.boj2290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainTest {
    static int S, N;
    static int left = 0;
    static char[][] monitor;
    static int[][] map = {
            {0, 1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 0, 1, 0, 0, 1, 0}, // 1
            {0, 1, 0, 1, 1, 1, 0, 1}, // 2
            {0, 1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 0, 1, 1, 1, 0, 1, 0}, // 4
            {0, 1, 1, 0, 1, 0, 1, 1}, // 5
            {0, 1, 1, 0, 1, 1, 1, 1}, // 6
            {0, 1, 0, 1, 0, 0, 1, 0}, // 7
            {0, 1, 1, 1, 1, 1, 1, 1}, // 8
            {0, 1, 1, 1, 1, 0, 1, 1}  // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        char[] chars = st.nextToken().toCharArray();

        N = chars.length;
        monitor = new char[2 * S + 3][(N) * (S + 3)];

        for (int i = 0; i < 2 * S + 3; i++) {
            for (int j = 0; j < (N) * (S + 3); j++) {
                monitor[i][j] = ' ';
            }
        }

        for (char aChar : chars) {
            int n = Integer.parseInt(aChar + "");

            if (map[n][1] == 1) fill(0, 0, left + 1, left + S, '-');
            if (map[n][4] == 1) fill(S + 1, S + 1, left + 1, left + S, '-');
            if (map[n][7] == 1) fill(2 * (S + 1), 2 * (S + 1), left + 1, left + S, '-');

            if (map[n][2] == 1) fill(1, S, left, left, '|');
            if (map[n][5] == 1) fill(S + 2, 2 * S + 1, left, left, '|');

            if (map[n][3] == 1) fill(1, S, left + S + 1, left + S + 1, '|');
            if (map[n][6] == 1) fill(S + 2, 2 * S + 1, left + S + 1, left + S + 1, '|');

            left += S + 3;
        }

        for (int i = 0; i < 2 * S + 3; i++) {
            for (int j = 0; j < left - 1; j++) {
                System.out.print(monitor[i][j]);
            }
            System.out.println();
        }

    }

    private static void fill(int r1, int r2, int c1, int c2, char c) {

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                monitor[i][j] = c;
            }
        }
    }
}
