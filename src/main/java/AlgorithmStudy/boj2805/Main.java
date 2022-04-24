package AlgorithmStudy.boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        long M = Long.parseLong(tmp[1]);

        String[] tree = br.readLine().split(" ");

        long[] height = new long[N];

        for (int i = 0; i < N; i++) {
            height[i] = Long.parseLong(tree[i]);
        }

        long min = 0;
        long max = Arrays.stream(height).max().getAsLong() + 1;
        long mid, sum;

        while (min < max) {
            mid = (min + max) / 2;
            sum = 0;
            for (long l : height) {
                if (l > mid) {
                    sum += (l - mid);
                }
            }
            // 같을 때 하한을 올림 -> 가장 오른쪽을 구하는 방법
            if (sum >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        // 결과적으로 min은 정답이 될 수 있는 값 + 1이 되므로, -1을 수행
        System.out.println(min - 1);

        // https://jackpot53.tistory.com/33
    }
}
