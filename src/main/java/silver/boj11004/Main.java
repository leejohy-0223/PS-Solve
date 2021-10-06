package silver.boj11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int value = 1_000_000_000;
    static boolean[] chk = new boolean[(value * 2) + 1];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            chk[tmp + value] = true;
            map.put(tmp + value, map.getOrDefault(tmp + value, 0) + 1);
        }

        int count = 0;

        for (int i = 0; i <= 2 * value; i++) {
            if(!chk[i]) continue;
            if (map.get(i) > 0) {
                count ++;
                if(count == K) {
                    System.out.println(i - value);
                    return;
                }
                map.put(i, map.get(i) - 1);
            }
        }
        br.close();
    }

}
