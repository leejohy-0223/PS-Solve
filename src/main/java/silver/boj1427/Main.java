package silver.boj1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        System.out.println(sb);
    }
}
