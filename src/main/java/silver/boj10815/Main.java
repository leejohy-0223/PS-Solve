package silver.boj10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] have;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        have = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(have);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(temp)).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int value) {
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (value > have[mid]) {
                lo = mid + 1;
            } else if (value < have[mid]) {
                hi = mid - 1;
            } else
                return 1;
        }
        return 0;

    }
}
