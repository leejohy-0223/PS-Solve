package silver.boj4307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int minL = -1;
            for (int i = 0; i < n; i++) {
                int fast = Math.min(arr[i], l - arr[i]);
                minL = Math.max(minL, fast);
            }
            int maxL = -1;
            for (int i = 0; i < n; i++) {
                maxL = Math.max(maxL, arr[i]);
                maxL = Math.max(maxL, l - arr[i]);
            }

            System.out.println(minL + " " + maxL);
        }
    }
}
