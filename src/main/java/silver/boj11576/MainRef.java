package silver.boj11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 변경 전 진수
        int b = Integer.parseInt(st.nextToken()); // 변경 후 진수

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Long> list = new ArrayList<>();

        long result = 0;

        // a -> 10진수 변경
        while(m > 0) {
            m--;
            result += (Integer.parseInt(st.nextToken()) * Math.pow(a, m));
        }

        System.out.println("result = " + result);

        String s = Integer.toString((int) result, a);

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar > 57) {
                System.out.print((char) (aChar - 87) + " ");
            } else
                System.out.print((char) (aChar) + " ");
        }
//
//        System.out.println();
//        Integer i = Integer.valueOf("1011", 2);
//        System.out.println(i);
    }
}
