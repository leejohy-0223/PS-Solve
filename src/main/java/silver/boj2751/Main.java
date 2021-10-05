package silver.boj2751;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001]; // 수는 중복되지 않으므로 사용 가능!!

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                bw.write(i - 1000000 + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
