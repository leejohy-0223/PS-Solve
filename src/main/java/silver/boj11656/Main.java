package silver.boj11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= s.length() - 1; i++) {
            list.add(s.substring(i));
        }
        list.sort(String::compareTo);

        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            sb.append(s1).append("\n");
        }

        System.out.println(sb);
    }
}
