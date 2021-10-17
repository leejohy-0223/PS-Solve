package silver.boj2447;

import java.io.*;

public class Main {
    static char[][] result;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        result = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(result[i]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void star(int x, int y, int N, boolean blank) {

        // blank가 true라면 공백이라는 의미
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    result[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없는 블록일 때(N == 1)
        if (N == 1) {
            result[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                star(i, j, size, count == 4);
                count++;
            }
        }
    }
}
