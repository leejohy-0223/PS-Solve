package SMTC_20220702.ps02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        int[] B = new int[N + 1];

        long[] accumA = new long[N + 1];
        long[] accumB = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        long sumA = 0, sumB = 0;
        for (int i = 1; i <= N; i++) {
            sumA += A[i];
            sumB += B[i];
            accumA[i] = sumA;
            accumB[i] = sumB;
        }

        long result = 0;
        List<Integer> target = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            long accA = accumulate(accumA, 1, i);
            long accB = accumulate(accumB, 1, i);
            if (accA == accB) {
                target.add(i);
            }
        }
        result += target.size();
        if (result != 0 && target.get(0) == 1) {
            target.remove(0);
        }

        for (Integer end : target) {
            for (int i = 2; i <= end; i++) {
                long accA = accumulate(accumA, i, end);
                long accB = accumulate(accumB, i, end);
                if (accA == accB) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static long accumulate(long[] accum, int i, int j) {
        return accum[j] - accum[i - 1];
    }
}
