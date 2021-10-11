package bronze.boj1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if(s.length() % 3 == 1) {
            s = "00" + s;
        } else if(s.length() % 3 == 2) {
            s = "0" + s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length()-2; i+=3) {
            char[] chars = s.substring(i, i + 3).toCharArray();

            int sum = (chars[0] - '0') * 4 + (chars[1] - '0') * 2 + (chars[2] - '0');
            sb.append(sum);
        }
        System.out.println(sb);
    }
}
