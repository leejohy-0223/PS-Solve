package silver.boj1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainTest {

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
        dividePaper(0, 0, N);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void dividePaper(int x, int y, int size) {

        int value = arr[x][y];
        // 모두 같은 값으로 채워진게 아니라면,
        if (!checkValue(value, x, y, size)) {
            for (int i = x; i < x + size; i += size / 3) {
                for (int j = y; j < y + size; j += size / 3) {
                    dividePaper(i, j, size / 3);
                }
            }
        }

    }

    private static boolean checkValue(int value, int x, int y, int size) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        result[value + 1]++;
        return true;
    }
}
