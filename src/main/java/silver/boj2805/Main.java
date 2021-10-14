package silver.boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long[] tree = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            maxValue = Math.max(maxValue, tree[i]);
        }

        long lo = 0;
        long hi = maxValue + 1;

        /*
         * 잘리는 양(count) > 필요 양(n) -> lo를 높여 mid를 올린 후, 잘리는 양을 줄인다.(lo = mid + 1)
         * 잘리는 양(count) < 필요 양(n) -> hi를 낮춰 mid를 내린 후, 잘리는 양을 늘린다.(hi = mid)
         * 잘리는 양(count) = 필요 양(n) -> 높이는 최대여야 한다. 따라서 여기에서도 lo를 높인다.(lo = mid + 1)
         */
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long count = 0;

            for (int i = 0; i < n; i++) {
                if (mid < tree[i]) {
                    count += tree[i] - mid;
                }
            }

            if (count >= m) {
                lo = mid + 1;
            } else
                hi = mid;
        }
        System.out.println(lo - 1); // 상한이므로 1만큼 빼줘야 한다.
    }
}
