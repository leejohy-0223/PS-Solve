package silver.boj2947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean swap;
        StringBuilder sb = new StringBuilder();

        while (true) {
            swap = false;

            for (int i = 0; i < 4; i++) {
                if (arr[i + 1] < arr[i]) {
                    swap = true;
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                    for (int j = 0; j < 5; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    sb.append("\n");
                }
            }
            // swap이 발생하지 않는다면 끝
            if (!swap) {
                break;
            }
        }
        System.out.println(sb);

    }
}
