package silver.boj13702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        long[] alcohols = new long[N];

        for (int i = 0; i < N; i++) {
            alcohols[i] = Integer.parseInt(br.readLine());
        }
        long max = Arrays.stream(alcohols).max().getAsLong();
        long lo = 0;
        long hi = max + 1;
        long mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;

            // 상한 : 같을 때도 lo를 올린다.
            if (K <= calculateCount(mid, alcohols)) {
                lo = mid + 1;
            } else
                hi = mid;
        }
        // 결과로, lo에는 하나 큰 값이 들어있다.
        System.out.println(lo - 1);
    }

    private static int calculateCount(long mid, long[] alcohols) {
        int count = 0;
        for (long alcohol : alcohols) {
            count += (alcohol / mid);
        }
        return count;
    }
}
