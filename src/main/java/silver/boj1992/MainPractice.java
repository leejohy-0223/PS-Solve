package silver.boj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPractice {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(chars[j] + "");
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);

    }

    private static void quadTree(int x, int y, int size) {

        int tmp = arr[x][y];
        // 현재 사이즈에 모두 들어오는지 체크, 안되면 재귀 실행
        if (!checkColor(tmp, x, y, size)) {
            sb.append("(");
            for (int i = x; i < x + size; i += size / 2) {
                for (int j = y; j < y + size; j += size / 2) {
                    quadTree(i, j, size / 2);
                }
            }
            sb.append(")");
        } else {
            sb.append(tmp);
        }
    }

    private static boolean checkColor(int tmp, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }
}
