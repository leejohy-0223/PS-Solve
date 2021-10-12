package silver.boj11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Long> list = new ArrayList<>();

        long result = 0;
        while(m > 0) {
            m--;
            result += (Integer.parseInt(st.nextToken()) * Math.pow(a, m));
        }

        while(result >= b) {
            list.add(result % b);
            result /= b;
        }
        list.add(result);

        int j=list.size()-1;
        while (j>=0) {
            System.out.print(list.get(j) + " ");
            j--;
        }
    }
}
