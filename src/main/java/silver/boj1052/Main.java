package silver.boj1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int bottle = 0;

        while (true) {
            int oneCount = Integer.bitCount(N);
            if (oneCount <= K) {
                System.out.println(bottle);
                return;
            }
            bottle++;
            N++;
        }
    }
}
