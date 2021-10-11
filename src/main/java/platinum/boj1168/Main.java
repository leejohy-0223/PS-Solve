package platinum.boj1168;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        for (int i = 0; i < N - 1; i++) {
            idx += K;
            idx %= list.size();
            sb.append(list.remove(idx)).append(", ");
        }
        sb.append(list.remove(0)).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
