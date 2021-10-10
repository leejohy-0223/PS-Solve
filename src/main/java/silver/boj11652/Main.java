package silver.boj11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    static int count = Integer.MIN_VALUE;
    static Map<Long, Integer> map = new HashMap<>();
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            long tmp = Long.parseLong(br.readLine());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        Set<Long> keys = map.keySet();
        for (Long key : keys) {

            if(map.get(key) == count) {
                if(key < result) {
                    result = key;
                    continue;
                }
            }
            if (map.get(key) > count) {
                count = map.get(key);
                result = key;
            }
        }
        System.out.println(result);
    }
}
