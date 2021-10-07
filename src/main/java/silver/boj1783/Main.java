package silver.boj1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 1;

        if(N == 1) {
            System.out.println(count);
            return;
        }

        if(N == 2) {
            int tmp = (M + 1) / 2;
            count = Math.min(tmp, 4);
            System.out.println(count);
            return;
        }

        if(N >= 3) {
            if(M < 7) {
                count = Math.min(M, 4);
                System.out.println(count);
                return;
            }
            count = M - 2;
            System.out.println(count);
        }
    }
}
