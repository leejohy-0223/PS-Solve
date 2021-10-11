package silver.boj9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long sum = 0;

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i+1; j < n; j++) {
                    sum += gcd(Math.max(arr[i], arr[j]), Math.min(arr[i], arr[j]));
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }

    private static long gcd(long max, long min) {
        while (min != 0) {
            long r = max % min;
            max = min;
            min = r;
        }
        return max;
    }
}
