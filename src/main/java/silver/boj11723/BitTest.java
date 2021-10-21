package silver.boj11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitTest {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 20;
        int m = Integer.parseInt(br.readLine());
        int s = 0;

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            String now = br.readLine();

            if (now.startsWith("add")) {
                s = (s | (1 << Integer.parseInt(now.substring(4)) - 1));
            } else if (now.startsWith("remove")) {
                s = (s & ~(1 << Integer.parseInt(now.substring(7)) - 1));
            } else if (now.startsWith("check")) {
                int result = (s & (1 << Integer.parseInt(now.substring(6)) - 1));

                if (result == 0) {
                    sb.append(0).append("\n");
                } else
                    sb.append(1).append("\n");
            } else if (now.startsWith("toogle")) {
                s = (s ^ (1 << Integer.parseInt(now.substring(7)) - 1));
            } else if (now.startsWith("all")) {
                s = (1 << n) - 1;
            } else if (now.startsWith("empty")) {
                s = 0;
            }
        }


//        String temp = "aaaaaa 1";
//        s = (s | (1 << Integer.parseInt(temp.substring(7)) - 1));
//        s = (s & ~(1 << Integer.parseInt(temp.substring(7)) - 1));
//        s = (1 << 5) - 1; // 예를들어 32(10000) 라면, 1개를 빼서 31(1111)로 만든다. 즉, 4개를 모두 1로 채운다.
//
//
//        System.out.println(s);
    }
}
