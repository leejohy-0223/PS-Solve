package silver.boj11723;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if (command.equals("add")) {
                set.add(num);
                continue;
            }

            if (command.equals("check")) {
                if (set.contains(num)) {
                    bw.write(1 + "\n");
                } else
                    bw.write(0 + "\n");
                continue;
            }

            if (command.equals("remove")) {
                set.remove(num);
                continue;
            }

            if (command.equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                } else
                    set.add(num);
                continue;
            }

            if (command.equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
                continue;
            }
            set.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
