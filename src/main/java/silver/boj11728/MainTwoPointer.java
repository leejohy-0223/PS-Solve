package silver.boj11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainTwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrN = new int[N];
        int[] arrM = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N + M];

        int ndx = 0;
        int mdx = 0;
        int idx = 0; // 통합
        while (ndx < N && mdx < M) {
            if(arrN[ndx] > arrM[mdx]) {
                arr[idx] = arrM[mdx];
                mdx++;
            } else {
                arr[idx] = arrN[ndx];
                ndx++;
            }
            idx++;
        }

        // n이 남았을 경우
        while (ndx < N) {
            arr[idx] = arrN[ndx];
            idx++;
            ndx++;
        }

        // m이 남았을 경우
        while (mdx < M) {
            arr[idx] = arrM[mdx];
            idx++;
            mdx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
