package silver.boj1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        int cnt;
        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int len = B.length() - A.length();

        for (int i = 0; i < (len + 1); i++) {
            cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) {
                    cnt ++;
                }
                if (cnt > min) {
                    break;
                }
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}
