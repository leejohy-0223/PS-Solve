package silver.boj1158;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainUsingList {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> num = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <=N ; i++) {
            num.add(i);
        }

        sb.append("<");
        int k = K - 1; // K = 3 -> k = 2

        sb.append(num.remove(k--));
        while(!num.isEmpty()) {
            sb.append(", ");
            k = (k + K) % num.size();
            sb.append(num.remove(k--));
        }
        sb.append(">");
        System.out.println(sb);
    }
}
