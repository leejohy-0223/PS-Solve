package silver.boj1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int count = 0;
        // 길이가 같을 경우
        if (a.length() == b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        }

        // 길이가 짧을 경우 && b가 a를 포함하고 있을 때
        if (b.contains(a)) {
            System.out.println(0);
            return;
        }


        int min = 50;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int temp = 0;
            for (int j = i; j < i + a.length(); j++) {
                if (b.charAt(j) != a.charAt(j - i)) {
                    temp++;
                }
            }
            min = Math.min(min, temp);
        }
        System.out.println(min);
    }
}
