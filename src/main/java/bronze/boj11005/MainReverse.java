package bronze.boj11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (N > 0) {
            long remain = N % B;
            if(remain < 10) {
                sb.append(remain);
            } else
                sb.append((char) (remain + 55));
            N /= B;
        }
        System.out.println(sb.reverse());
    }
}
