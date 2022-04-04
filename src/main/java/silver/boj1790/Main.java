package silver.boj1790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 최대 숫자
        int k = Integer.parseInt(st.nextToken()); // target

        int start = 1;
        int end = n;
        int mid = 0, sum = 0;

        // k가 1부터 n까지 범위 밖이라면 -1 출력
        if (getLength(n) < k) {
            System.out.println(-1);
            return;
        }

        while (start <= end) {
            mid = (start + end) / 2;

            sum = getLength(mid);
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println("sum = " + sum);
            System.out.println("mid = " + mid);
            System.out.println();

            // sum이 작으면, 아래를 올려줘야 함
            if (sum < k) {
                start = mid + 1;
                continue;
            }
            // sum이 크면, 위를 낮춰줘야 함
            if (sum > k) {
                end = mid - 1;
                continue;
            }

            // 같다면 현재 값의 마지막 인자가 답임
            String s = mid + "";
            System.out.println("here!");
            System.out.println(s.charAt(s.length() - 1));
            return;
        }
        // sum이 k보다 크다면, 해당 mid 안에 답이 있다.

        int idx;
        String s;
        if(sum > k) {
            System.out.println("here2");
            idx = sum - k; // 뒤에서 idx번째 수가 답이다.
            s = mid + "";
            System.out.println(s.charAt(s.length() - 1 - idx));
        } else {
            System.out.println("here3");
            int next = mid + 1;
            s = next + "";
            idx = k - sum;
            System.out.println(s.charAt(idx - 1));
        }
    }

    private static int getLength(int mid) {
        int sum;
        // mid까지 이어붙인 길이 계산
        int len = (mid + "").length();
        // 10의 승수
        int stopper = (int) Math.pow(10, len - 1);

        sum = (mid - stopper + 1) * len;

        while (--len > 0) {
            int nStop = (int) Math.pow(10, len - 1);
            sum += (nStop * 9 * len);
        }
        return sum;
    }
}
