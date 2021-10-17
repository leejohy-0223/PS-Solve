package bronze.boj2875;

import java.io.*;
import java.util.StringTokenizer;

public class MainSimple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            if ((n / 2) < m) {
                m--;
            } else
                n--;
        }

        System.out.print(Math.min((n / 2), m));
    }
}
