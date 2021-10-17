package bronze.boj2875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= k; i++) {
            int tempN = n - i;
            int tempM = m - (k - i);

            if (tempN < 0 || tempM < 0) {
                continue;
            }

            if (tempN >= tempM) {
                if (tempN / 2 <= tempM) {
                    result = Math.max(result, tempN / 2);
                } else
                    result = Math.max(result, tempM);
            } else
                result = Math.max(result, tempN / 2);
        }
        System.out.println(result);
    }
}
