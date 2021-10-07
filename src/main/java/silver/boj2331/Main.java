package silver.boj2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Long, Integer> map = new HashMap<>();

        int idx = 1;
        map.put(A, idx);

        long div = A;
        while (true) {
            long result = 0;
            while (div!=0) {
                long tmp = div % 10;
                result += Math.pow(tmp, P);
                div /= 10;
            }
            if(map.containsKey(result)) {
                System.out.println(map.get(result) - 1);
                return;
            }
            map.put(result, ++idx);
            div = result;
        }
    }
}
