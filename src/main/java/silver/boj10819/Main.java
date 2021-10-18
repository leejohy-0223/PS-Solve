package silver.boj10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] tmp;
    static boolean[] chk;
    static int N;
    static int Max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];
        chk = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
        System.out.println(Max);

    }

    static void DFS(int L) {
        if (L == N) {
            calculation(tmp);
            for (int i : tmp) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i<arr.length; i++) {
            if(!chk[i]) {
                chk[i] = true;
                tmp[L] = arr[i];
                DFS(L + 1);
                chk[i] = false;
            }
        }
    }

    private static void calculation(int[] tmp) {
        int sum = 0;
        for (int i = 1; i < N ; i++) {
            sum += Math.abs(tmp[i - 1] - tmp[i]);
        }
        Max = Math.max(Max, sum);

    }

}
