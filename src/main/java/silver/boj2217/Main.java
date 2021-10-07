package silver.boj2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

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
                i++;
            }
        }

        System.out.println(result);
    }
}
