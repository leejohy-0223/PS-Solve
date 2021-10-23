package silver.boj17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();

        int i = 0;
        while (i < s.length) {
            if (s[i] == '<') {
                while (s[i] != '>') {
                    i++;
                }
                i++; // >의 다음거 가리키도록 인덱스 변경
            }

            // i가 공백이 아니라면, 문자이므로 여기에서부터 뒤집어야 함.
            if (i < s.length && s[i] != ' ') {
                int start = i;

                while (i < s.length && s[i] != '<' && s[i] != ' ') {
                    i++;
                }

                // 위의 것 중, 하나라도 만족을 못한 i를 가리키게 됨. 따라서 그 이전거를 가리키도록 변경
                int end = i - 1;
                while (start < end) {
                    char tmp = s[start];
                    s[start] = s[end];
                    s[end] = tmp;
                    start++;
                    end--;
                }

                // 공백이아닌건 '<'를 의미하므로 i를 증가시킬 필요 없다. 맨 위에서 알아서 처리될 것이다.
                if (i < s.length && s[i] == ' ') {
                    i++;
                }
            }

        }
        for (char c : s) {
            sb.append(c);
        }
        System.out.println(sb);

    }
}
