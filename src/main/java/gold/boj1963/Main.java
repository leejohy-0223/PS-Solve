package gold.boj1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] chk;
    static boolean[] prime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // prime = false = 소수
        prime[0] = prime[1] = true;

        for (int i = 2; i < 10000; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<10000; j+=i) {
                    prime[j] = true;
                }
            }
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int init = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            chk = new boolean[10000];
            solve(init, target);
        }
        System.out.println(sb);
    }

    private static void solve(int init, int target) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(init);
        chk[init] = true;
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer tmp = queue.poll();

                if (tmp == target) {
                    sb.append(depth).append("\n");
                    return;
                }

                int temp = tmp;

                // 자릿수 파싱
                int[] arr = new int[4];
                int j = 3;
                while(j >= 0) {
                    arr[j] = temp % 10;
                    temp /= 10;
                    j--;
                }

                // 천의 자리 변경 & check
                for (int k = 1; k <= 9; k++) {
                    int value = (k * 1000) + (arr[1] * 100) + (arr[2] * 10) + arr[3];
                    if(!chk[value] && !prime[value]) {
                        chk[value] = true;
                        queue.offer(value);
                    }
                }

                // 백의 자리 변경 & check
                for (int k = 0; k <= 9; k++) {
                    int value = (arr[0] * 1000) + (k * 100) + (arr[2] * 10) + arr[3];
                    if(!chk[value] && !prime[value]) {
                        chk[value] = true;
                        queue.offer(value);
                    }
                }

                // 십의 자리 변경 & check
                for (int k = 0; k <= 9; k++) {
                    int value = (arr[0] * 1000) + (arr[1] * 100) + (k * 10) + arr[3];
                    if(!chk[value] && !prime[value]) {
                        chk[value] = true;
                        queue.offer(value);
                    }
                }

                // 일의 자리 변경 & check
                for (int k = 0; k <= 9; k++) {
                    int value = (arr[0] * 1000) + (arr[1] * 100) + (arr[2] * 10) + k;
                    if(!chk[value] && !prime[value]) {
                        queue.offer(value);
                    }
                }
            }
            depth++;
        }
        sb.append("Impossible").append("\n");
    }

}
