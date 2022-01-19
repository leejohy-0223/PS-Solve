package silver.boj10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] target = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(target);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int find;
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            find = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target, find)).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] target, int find) {
        int lo = 0;
        int hi = target.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target[mid] > find) { // mid를 낮춰야 함
                hi = mid - 1;
            } else if (target[mid] < find) {
                lo = mid + 1;
            } else
                return 1;
        }
        return 0;
    }
}
