package silver.boj14627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int S = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);

        long[] onionLengths = new long[S];

        for (int i = 0; i < S; i++) {
            onionLengths[i] = Integer.parseInt(br.readLine());
        }

        long maxL = Integer.MIN_VALUE;

        for (long onionLength : onionLengths) {
            maxL = Math.max(maxL, onionLength);
        }

        long lo = 1; // 실제 최솟값을 넣어야 한다.
        long hi = maxL + 1; // 최대보다 하나 더 크게 넣어준다.

        // upper bound
        lo = upperBound(C, onionLengths, lo, hi);

        System.out.println(makeRamenOnion(lo - 1, onionLengths, C));
    }

    private static long upperBound(int C, long[] onionLengths, long lo, long hi) {
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            int makeCount = calculateMakeAbleCount(mid, onionLengths);
            if (makeCount >= C) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static long makeRamenOnion(long use, long[] onionLengths, int orderCount) {
        long sum = 0;
        for (long onionLength : onionLengths) {
            sum += onionLength;
        }
        return sum - (orderCount * use);
    }

    private static int calculateMakeAbleCount(long mid, long[] onionLengths) {
        int count = 0;
        for (long onionLength : onionLengths) {
            count += (onionLength / mid);
        }
        return count;
    }

}
