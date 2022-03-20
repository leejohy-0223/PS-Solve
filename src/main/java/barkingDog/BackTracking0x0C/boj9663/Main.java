package barkingDog.BackTracking0x0C.boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int result = 0;
    static boolean[] chk1;
    static boolean[] chk2;
    static boolean[] chk3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chk1 = new boolean[N];
        chk2 = new boolean[N * 2 - 1];
        chk3 = new boolean[N * 2 - 1];
        func(0); // 0번째 row부터 시작한다.
        System.out.println(result);
    }

    /**
     * func(cur) -> cur개의 위치가 정해졌으며, board[cur]의 위치를 정할 차례이다.
     */
    private static void func(int row) {
        if (row == N) {
            result++;
            return;
        }

        /**
         * (N, M 순열 문제)에서는 for문 돌리면서, 사용하지 않은 수를 대상으로 recursive를 적용했다.
         * 여기에서는 issue1, issue2, issue3을 모두 만족하는 수를 대상으로 진행한다.
         */
        for (int column = 0; column < N; column++) {
            if (chk1[column] || chk2[column + row] || chk3[column - row + N - 1]) {
                continue;
            }
            chk1[column] = true;
            chk2[column + row] = true;
            chk3[column - row + N - 1] = true;
            func(row + 1);
            chk1[column] = false;
            chk2[column + row] = false;
            chk3[column - row + N - 1] = false;
        }
    }
}
