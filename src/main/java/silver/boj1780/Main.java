package silver.boj1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] result = new int[3];
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        StringBuilder sb = new StringBuilder();

        for (int tmp : result) {
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);

    }

    private static void divide(int startX, int startY, int size) {

        int tmp = arr[startX][startY];
        if (checkTmp(startX, startY, tmp, size)) {
            return;
        }

        int nSize = size / 3;
        for (int i = startX; i < startX + size; i += nSize) {
            for (int j = startY; j < startY + size; j += nSize) {
                divide(i, j, nSize);
            }
        }
    }

    private static boolean checkTmp(int X, int Y, int value, int size) {
        for (int i = X; i < X + size; i++) {
            for (int j = Y; j < Y + size; j++) {
                if (value != arr[i][j]) {
                    return false;
                }
            }
        }
        result[value + 1]++;
        return true;
    }
}
