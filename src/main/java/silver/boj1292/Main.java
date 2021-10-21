package silver.boj1292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[1001];

        int num = 1, copy = 1;

        for (int i = 1; i <= 1000; i++) {
            arr[i] = copy;
            num--;
            if (num == 0) {
                num = ++copy;
            }
        }
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

    }
}
