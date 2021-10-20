package silver.boj3568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb;
        StringBuilder result = new StringBuilder();
        String basic = st.nextToken();
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            char[] chars = temp.toCharArray();
            int idx = 0;
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isAlphabetic(chars[i])) {
                    idx = i;
                    break;
                }
            }

            sb = new StringBuilder(temp.substring(idx, temp.length()-1)).reverse();

            String s = sb.toString();
            if (s.contains("][")) {
                s = sb.toString().replace("][", "[]");
            }

            result.append(basic).append(s).append(" ").append(temp.substring(0, idx)).append(";").append("\n");
        }
        System.out.println(result);

    }
}
