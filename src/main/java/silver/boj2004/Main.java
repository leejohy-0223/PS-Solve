package silver.boj2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = Math.min(findPow(2, n) - (findPow(2, n - m) + findPow(2, m)), findPow(5, n) - (findPow(5, n - m) + findPow(5, m)));
        System.out.println(result);
    }

    private static int findPow(int pow, int n) {

        int count = 0;
        while(n >= pow) {
            count += n / pow;
            n /= pow;
        }
        return count;
    }
}
