package silver.boj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainBfs {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chk = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        int count = 0;

        for (int j = 1; j <= N ; j++) {
            if (!chk[j]) {
                count++;
                chk[j] = true;
                BFS(j);
            }
        }
        System.out.println(count);
    }

    private static void BFS(int i) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer tmp : arr.get(poll)) {
                if(!chk[tmp]) {
                    chk[tmp] = true;
                    queue.offer(tmp);
                }
            }
        }
    }
}
