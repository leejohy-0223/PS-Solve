package silver.boj2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>((o1, o2) -> o2 - o1);
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        long result = 0;

        int i = 1;
        for (Long value : list) {
            long product = value * i;
            if(result < product) {
                result = product;
            }
            i++;
        }
        // 왜 탈출하면 안되냐 하면,, 11, 5, 4일경우 4까지 가야 더 큰 경우가 있다.
        // 11 -> 11, 5 -> 10, 4 -> 12이므로!!!



        System.out.println(result);
    }
}
