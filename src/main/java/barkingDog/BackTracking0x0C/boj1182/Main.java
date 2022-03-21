package barkingDog.BackTracking0x0C.boj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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

        for (int i = 1; i <= N; i++) {
            sumTemplate = new int[i];
            func(i, 0, 0);
        }
        System.out.println(result);

    }

    private static void func(int size, int now, int firstValue) {
        if (size == now) {
            int sum = 0;
            for (int num : sumTemplate) {
                sum += num;
            }
            if (sum == S) {
                result++;
            }
            return;
        }

        for (int i = firstValue; i < N; i++) {
            sumTemplate[now] = arr[i];
            func(size, now + 1, i + 1);
        }

    }
}
