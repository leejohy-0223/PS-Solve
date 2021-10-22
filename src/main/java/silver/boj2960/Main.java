package silver.boj2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime = new boolean[1001]; // false : 소수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                count++;
                if (count == k) {
                    System.out.println(i);
                    return;
                }
                for (int j = i * i; j <= n; j += i) {
                    if (!prime[j]) {
                        prime[j] = true;
                        count++;
                        if (count == k) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
