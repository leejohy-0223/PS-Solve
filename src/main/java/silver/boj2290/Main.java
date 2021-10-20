package silver.boj2290;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int S, N;
    static int left;
    static String[][] board;
    static int[][] map = {
            { 0, 1, 1, 1, 0, 1, 1, 1 },
            { 0, 0, 0, 1, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 1, 0, 1 },
            { 0, 1, 0, 1, 1, 0, 1, 1 },
            { 0, 0, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 1, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 0, 1, 1, 1, 1 },
            { 0, 1, 0, 1, 0, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1 }
    };

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        String[] num = st.nextToken().split("");
        N = num.length;
        board = new String[2 * S + 3][N * (S + 3)]; // 가로는 (s+2 + 1 - 공백)

        for (int i = 0; i < 2 * S + 3; i++)
            for (int j = 0; j < N * (S + 3); j++)
                board[i][j] = " ";


        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(num[i]);
            if (map[n][1] == 1) fill(0, 0, left + 1, left + S, "-");
            if (map[n][4] == 1) fill(S + 1, S + 1, left + 1, left + S, "-");
            if (map[n][7] == 1) fill(2 * (S + 1), 2 * (S + 1), left + 1, left + S, "-");

            if (map[n][2] == 1) fill(1, S, left, left, "|");
            if (map[n][5] == 1) fill(1 + (S + 1), S + (S + 1), left, left, "|");

            if (map[n][3] == 1) fill(1, S, left + S + 1, left + S + 1, "|");
            if (map[n][6] == 1) fill(1 + (S + 1), S + (S + 1), left + S + 1, left + S + 1, "|");

            left += S + 3; // S 길이 + 작대기 양쪽 각각 1씩(2) + 공백(1)
        }

        result();
        bw.flush();
        bw.close();
        br.close();

    }

    public static void result() throws IOException {
        for (int i = 0; i < 2 * S + 3; i++) {
            for (int j = 0; j < left; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }
    }

    public static void fill(int sx, int ex, int sy, int ey, String str) {
        for (int x = sx; x <= ex; x++)
            for (int y = sy; y <= ey; y++)
                board[x][y] = str;
    }
}
