package silver.boj2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] home;
    static int n, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        home = new long[n];
        for (int i = 0; i < n; i++) {
            home[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(home);

        long left = 1; // 이 부분을 home[0]으로 하면 왜 안될까? -> home[0]이
        long right = home[home.length - 1] + 1;

        while (left < right) {
            long mid = (left + right) / 2;

            // 최대니까 상한(UpperCase), 즉 같아도 아래를 올리는 방식을 채택한다.
            if (counting(mid) >= c) { // counting이 더 많을 경우 Mid를 크게 해서, 즉 Left를 크게해서 범위를 넓혀 counting을 줄인다. 같을 경우에도 동일하게 진행
                left = mid + 1;
            } else
                right = mid;
        }

        System.out.println(left - 1);
    }

    // 주어진 mid 값을 이용해서 설치한 공유기 개수 반환
    private static long counting(long mid) {
        int count = 1;
        long dist = home[0] + mid;

        for (int i = 1; i < n; i++) {
            if(dist > home[i]) continue;
            dist = home[i] + mid;
            count++;
        }
//        System.out.println("mid = " + mid);
//        System.out.println("count = " + count);
//        System.out.println();
        return count;
    }
}
