package silver.boj1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        int num = Integer.parseInt(s);

        // 10의 승수
        int stopper = (int) Math.pow(10, len - 1);

        int sum = (num - stopper + 1) * len;

        while (--len > 0) {
            int nStop = (int) Math.pow(10, len - 1);
            sum += (nStop * 9 * len);
        }
        System.out.println(sum);
    }
}
