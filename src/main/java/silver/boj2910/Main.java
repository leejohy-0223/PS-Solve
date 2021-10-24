package silver.boj2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>((o1, o2) -> o2 - o1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> chk = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for (int j = 0; j < N; j++) {
            if (!chk.contains(arr[j])) {
                chk.add(arr[j]);
                int count = 0;
                for (int k = j; k < N; k++) {
                    if (arr[j] == arr[k]) {
                        count++;
                    }
                }
                if (map.containsKey(count)) {
                    map.get(count).add(arr[j]);
                } else {
                    map.put(count, new ArrayList<>());
                    map.get(count).add(arr[j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Integer key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);

            for (Integer tmp : list) {
                for (int j = 0; j < key; j++) {
                    sb.append(tmp).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}
