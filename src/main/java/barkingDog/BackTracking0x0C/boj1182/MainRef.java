package barkingDog.BackTracking0x0C.boj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRef {
    static int[] sumTemplate;
    static int[ ] arr;
    static int result = 0;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N];

        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        func(0, 0);
        if (S == 0) {
            result--;
        }
        System.out.println(result);

    }

    private static void func(int cur, int tot) {
        if (cur == N) {
            if (tot == S) {
                result ++;
            }
            return;
        }

        func(cur + 1, tot);
        func(cur + 1, tot + arr[cur]);

    }

}
