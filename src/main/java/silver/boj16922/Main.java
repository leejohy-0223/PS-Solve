package silver.boj16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] roma = {1, 5, 10, 50};
    static int[] pm;
    static int N;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pm = new int[N];

        comb(0, 0);

        System.out.println(list.size());
    }

    private static void comb(int L, int S) {
        if (L == N) {
            // sum 진행
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += pm[i];
            }
            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }

        for (int i = S; i < 4; i++) {
            pm[L] = roma[i];
            comb(L + 1, i);
        }
    }
}
