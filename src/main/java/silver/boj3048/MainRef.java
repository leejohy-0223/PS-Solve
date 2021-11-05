package silver.boj3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainRef {
    static char[] result;

    static class Ants {
        char name;
        int position;
        int ready;
        int target;

        public Ants(char name, int position, int ready, int target) {
            this.name = name;
            this.position = position;
            this.ready = ready;
            this.target = target;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String s1 = br.readLine();
        String s2 = br.readLine();

        ArrayList<Ants> list = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(s1);
        s1 = sb.reverse().toString();

        // 왼쪽 개미그룹(N1)을 arrayList에 넣기
        int ready = n1 - 1;
        for (int i = 0; i < n1; i++) {
            list.add(new Ants(s1.charAt(i), i, ready--, i + n2));
        }


        result = (s1 + s2).toCharArray();

        if (T == 0) {
            for (char c : result) {
                System.out.print(c);
            }
            return;
        }

        int time = 0;
        while (time != T) {
            for (Ants ants : list) {
                if (ants.ready == 0 && ants.target != ants.position) {
                    // 준비되었고, 타겟이 아닌 개미만 움직인다.
                    ants.position++;
                } else {
                    ants.ready--;
                }
            }
            time++;
        }

        result = new char[n1 + n2];
        Arrays.fill(result, ' ');

        for (Ants ants : list) {
            int position = ants.position;
            result[position] = ants.name;
        }

        char[] chars = s2.toCharArray();

        for (char aChar : chars) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] == ' ') {
                    result[i] = aChar;
                    break;
                }
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (char c : result) {
            sb2.append(c);
        }
        System.out.println(sb2);
    }
}
