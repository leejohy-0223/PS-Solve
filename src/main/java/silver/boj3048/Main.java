package silver.boj3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String s1 = br.readLine();
        String s2 = br.readLine();

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(s1);
        s1 = sb.reverse().toString();

        result = (s1 + s2).toCharArray();

        int count = 0;
        while (result[n2 - 1] != s2.charAt(n2 - 1)) {

            if (count == T) {
                for (char c : result) {
                    System.out.print(c);
                }
                return;

            }
            for (int i = 0; i < result.length - 1; i++) {
                if (!s1.contains(result[i] + "")) continue;
                if (!s1.contains(result[i + 1] + "")) {
                    swap(i, i + 1);
                    i++;
                }
            }
            count++;
        }
        for (char c : result) {
            System.out.print(c);
        }
    }

    private static void swap(int i1, int i2) {
        char tmp = result[i1];
        result[i1] = result[i2];
        result[i2] = tmp;
    }

}
