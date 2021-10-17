package gold.boj2448;

import java.io.*;
import java.util.Arrays;

public class MainRef {
    static char[][] str = null;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine()); // 3*2^k  (3, 6, 12, 24, 48, ...) (k<=10)

        str = new char[n][2 * n - 1]; // x,y 2차원 그림판 ... 수직방향이 x축, 수평이 y축 임...

        for (int x = 0; x < n; x++)
            Arrays.fill(str[x], ' ');

        drawStar(0, n - 1, n);

        for (int i = 0; i < n; i++) {
            bw.write(str[i]);
            bw.write('\n');
        }

        bw.flush();

    }

    /**
     * 삼각형을 그리는 재귀함수
     *
     * @param x 삼각형을 꼭대기 x 좌표
     * @param y 삼각형을 꼭대기 y 좌표
     * @param n 삼각형 높이
     */
    public static void drawStar(int x, int y, int n) {
        if (n == 3) {
            str[x][y] = '*'; // 1번째 줄
            str[x + 1][y - 1] = str[x + 1][y + 1] = '*'; // 2번째 줄
            str[x + 2][y - 2] = str[x + 2][y - 1] = str[x + 2][y] = str[x + 2][y + 1] = str[x + 2][y + 2] = '*'; // 3번째줄
            return;
        }

        drawStar(x, y, n / 2);
        drawStar(x + n / 2, y - n / 2, n / 2);
        drawStar(x + n / 2, y + n / 2, n / 2);
    }
}
