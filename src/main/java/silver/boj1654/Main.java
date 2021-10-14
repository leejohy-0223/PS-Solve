package silver.boj1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lan = new long[k];

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, lan[i]);
        }

        long lo = 0;
        long hi = maxValue + 1; // bound를 구하기 위해서 앞서 배열에서도 실제 인덱스가 아닌, 인덱스 +1부터 탐색을 진행했다.
        long mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;

            long count = 0;
            for (long l : lan) {
                count += (l / mid);
            }

            /*
             * count > n일 경우, lo를 올려 mid를 크게해서 count를 내려야 한다.
             * count == n일 경우, lo를 더 올려서 최대 가능한 인덱스 + 1만큼을 반환해야 한다.
             */
            if (count >= n) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }

        System.out.println(lo - 1); // n보다 1만큼 큰 인덱스가 반환되었으므로, 다시 -1만큼 빼주면 된다.
    }
}
