package silver.boj16208;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = 0;
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }

        for (int i = 0; i < N; i++) {
            long tmp = arr[i];
            long sub = sum - tmp;
            result += (sub) * tmp;
            sum -= tmp;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
