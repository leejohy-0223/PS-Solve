package silver.boj11723;

import java.io.*;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 20;
        int m = Integer.parseInt(br.readLine());
        int s = 0;

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String temp = br.readLine();

            if (temp.startsWith("add")) {
                s = (s | (1 << Integer.parseInt(temp.substring(4)) - 1)); // or 연산을 통해 자릿수를 1로 채운다.
            } else if (temp.startsWith("remove")) {
                s = (s & ~(1 << Integer.parseInt(temp.substring(7)) - 1)); // and 연산을 통해 해당 자리수를 지운다.
            } else if (temp.startsWith("check")) {

                int result = (s & (1 << Integer.parseInt(temp.substring(6)) - 1)); // 해당 비트가 있으면 result는 그 부분만 1이 된다. 없다면 result가 0이 된댜.
                if (result == 0) {
                    sb.append(0).append("\n");
                } else
                    sb.append(1).append("\n");
            } else if (temp.startsWith("toggle")) {
                s = (s ^ (1 << Integer.parseInt(temp.substring(7)) - 1)); // 해당 숫자를 반전시킴
            } else if (temp.startsWith("all")) {
                s = (1 << n) - 1;
            } else if (temp.startsWith("empty")) {
                s = 0;
            }
        }
        System.out.println(sb);
    }
}
