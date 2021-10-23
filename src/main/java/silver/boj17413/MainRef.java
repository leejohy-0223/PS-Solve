package silver.boj17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRef {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();

        int i = 0;
        while (i < s.length) {
            if (s[i] == '<') {
                while (s[i] != '>')
                    i++;
                i++;
            }

            if (i < s.length && s[i] != ' ') {
                int start = i;
                while (i < s.length && s[i] != '>' && s[i] != '<' && s[i] != ' ')
                    i++;
                int end = i - 1;
                while (start < end) {
                    char temp = s[start];
                    s[start] = s[end];
                    s[end] = temp;
                    start++;
                    end--;
                }
            }

            if (i < s.length && s[i] == ' ')
                i++;
        }

        for (char c : s) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
