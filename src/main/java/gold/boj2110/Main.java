package gold.boj2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int houseCount = Integer.parseInt(tmp[0]);
        int modemCount = Integer.parseInt(tmp[1]);

        long[] homePosition = new long[houseCount];

        for (int i = 0; i < houseCount; i++) {
            homePosition[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(homePosition);

        long lo = 0; // 0도 가능
        long hi = homePosition[homePosition.length - 1] + 1;

        while (lo < hi) {
            long mid = (lo + hi) / 2; // 그 다음까지의 거리 계산
            int count = 1;
            long next = homePosition[0] + mid;
            for (int i = 1; i < homePosition.length; i++) {
                if (next > homePosition[i]) {
                    continue;
                }
                count++;
                next = (homePosition[i] + mid);
            }
            if (count >= modemCount) { // count 가 주어진 공유기보다 많으면, 줄여야 한다. count 를 줄이려면 간격을 넓혀야 하며, mid 를 올려야 하고, lo를 올려야 한다.
                lo = mid + 1;
            } else
                hi = mid;
        }
        System.out.println(lo - 1);

    }
}
