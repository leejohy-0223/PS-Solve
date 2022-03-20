package barkingDog.BackTracking0x0C.boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] chk;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[M];
        chk = new boolean[N + 1];

        tracking(0);
        System.out.println(sb);
    }

    /**
     *  idx 만큼 완성되었으며, arr[idx]번째를 계산한다.
     *  최초는 tacking(0) : 0만큼 완성되었으며 arr[0]에 뭐가 들어갈 지 정한다.
     */
    private static void tracking(int idx) {
        if (idx == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!chk[i]) {
                arr[idx] = i;
                chk[i] = true;
                tracking(idx + 1);
                chk[i] = false;
            }
        }
    }
}
