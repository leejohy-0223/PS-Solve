package silver.boj1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (N-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < list.size(); i++) {
            int tip = list.get(i) - i;
            if (tip < 0) {
                break;
            }
            result += tip;
        }
        System.out.println(result);
    }
}
