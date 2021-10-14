package silver.boj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            long target = Long.parseLong(st.nextToken());
            findCount(target);
        }
        System.out.println(sb);
    }

    private static void findCount(long target) {
        int lower = lowerCase(target);
        int upper = upperCase(target);

        sb.append(upper - lower).append(" ");
    }

    private static int lowerCase(long target) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target <= arr[mid]) {
                hi = mid;
            } else
                lo = mid + 1;

        }
        return lo;
    }

    private static int upperCase(long target) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target >= arr[mid]) {
                lo = mid + 1;
            } else
                hi = mid;
        }
        return lo;
    }

}
