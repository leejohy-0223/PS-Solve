package silver.boj17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPractice {
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
                i++;
            }
            // 위의 결과로 맨 끝 태그를 가리키게 된다면 i는 outOfbound가 되었을 것이다. 따라서 여기서 끝낸다.
            if (i >= s.length) {
                break;
            }

            // 그 다음도 태그라면, while 다시 돌리기
            if (s[i] == '<') {
                continue;
            }

            // i가 공백이라면 다음꺼 탐색
            if (s[i] == ' ') {
                i++;
                continue;
            }

            // 현재 시점부터, 다음 태그 전까지 찾기
            int j = i + 1;
            while (j < s.length && s[j] != '<' && s[j] != ' ') {
                j++;
            }
            j--; // 이 시점까지 뒤집기
            swap(i, j, s);

            i = j + 1;
        }
        for (char c : s) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    private static void swap(int start, int stop, char[] s) {
        while (start < stop) {
            char tmp = s[start];
            s[start] = s[stop];
            s[stop] = tmp;
            start++;
            stop--;
        }
    }
}
