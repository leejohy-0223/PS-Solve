package silver.boj11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[1] = 1;

        for (int i = 2; i <=20 ; i++) {
            arr[i] = arr[i-1]*2 +1;
        }

        sb.append(arr[N]).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);

    }

    /**
     * @param n     : 원판의 개수
     * @param start : 출발지
     * @param mid   : 옮기기 위해 이동해야 할 장소
     * @param to    : 목적지
     */
    public static void hanoi(int n, int start, int mid, int to) {
        // 이동할 원반 수가 0개라면 return
        if (n == 0) {
            return;
        }

        // STEP 1 : N-1개를 start에서 mid로 이동
        hanoi(n - 1, start, to, mid);

        // STEP 2 : 1개를 start에서 to으로 이동
        sb.append(start).append(" ").append(to).append("\n");

        // STEP 3 : N-1개를 mid에서 to으로 이동
        hanoi(n - 1, mid, start, to);
    }
}
