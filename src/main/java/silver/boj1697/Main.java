package silver.boj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] chk = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        chk[N] = true;
        queue.offer(N);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer tmp = queue.poll();

                if (tmp == K) {
                    System.out.println(depth);
                    return;
                }

                if ((tmp - 1) >= 0 && !chk[tmp - 1]) {
                    chk[tmp - 1] = true;
                    queue.offer(tmp - 1);
                }

                if ((tmp + 1) <= 100000 && !chk[tmp + 1]) {
                    chk[tmp + 1] = true;
                    queue.offer(tmp + 1);
                }

                if ((tmp * 2) <= 100000 && !chk[tmp * 2]) {
                    chk[tmp * 2] = true;
                    queue.offer(tmp * 2);
                }
            }
            depth++;
        }
    }
}
