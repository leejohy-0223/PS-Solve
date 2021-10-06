package silver.boj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer, ArrayList<String>> map = new HashMap<>();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(map.containsKey(key)) {
                map.get(key).add(name);
                continue;
            }
            map.put(key, new ArrayList<>());
            map.get(key).add(name);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 200; i++) {
            if(map.containsKey(i)) {
                for (String s : map.get(i)) {
                    sb.append(i).append(" ").append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
