package silver.boj17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '<') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '>') {
                        sb.append(s.substring(i, j + 1));
                        i = (j + 1);
                        break;
                    }
                }
            } else {
                for (int j = i; j < s.length() ;) {
                    if(s.charAt(j) == ' ' || j == s.length() - 1 || s.charAt(j) == '<') {
                        StringBuilder rev = new StringBuilder(s.substring(i, j));

                        if (j == s.length() - 1) {
                            rev.append(s.charAt(j));
                        }

                        rev.reverse();
                        sb.append(rev);

                        if (s.charAt(j) == '<') {
                            i = j;
                        } else {
                            sb.append(" ");
                            i = (j + 1);
                        }
                        break;
                    } else {
                        j++;
                    }
                }
            }
        }
        System.out.println(sb);

    }
}
