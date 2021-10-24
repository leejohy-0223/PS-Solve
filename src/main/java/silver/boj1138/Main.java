package silver.boj1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N + 1];
        // 2 1 2 1 0 0

        for (int i = 1; i <= N; i++) {
            int count = arr[i];

            for (int j = 1; j <= N; j++) {
                if (count == 0 && result[j] == 0) {
                    result[j] = i;
                    break;
                }
                if (result[j] == 0) {
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
