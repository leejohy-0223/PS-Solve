package silver.boj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

    private static void quadTree(int i, int j, int size) {

        if (checkTar(i, j, size, arr[i][j])) {
            sb.append(arr[i][j]);
            return;
        }

        sb.append("(");

//        // 왼쪽 위
//        quadTree(i, j, size / 2);
//
//        // 오른쪽 위
//        quadTree(i, j + (size / 2), size / 2);
//
//        // 왼쪽 아래
//        quadTree(i + (size / 2), j, size / 2);
//
//        // 오른쪽 아래
//        quadTree(i + (size / 2), j + (size / 2), size / 2);

        int newSize = size / 2;
        for (int k = i; k < i + size; k += newSize) {
            for (int l = j; l < j + size; l += newSize) {
                quadTree(k, l, newSize);
            }
        }

        sb.append(")");
    }

    private static boolean checkTar(int i, int j, int size, int value) {

        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (arr[k][l] != value) {
                    return false;
                }
            }
        }
        return true;
    }

}
