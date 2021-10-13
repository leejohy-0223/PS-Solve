package silver.boj11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] chk;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        chk = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        BFS(1);

        for (int i = 2; i <=N ; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        chk[n] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer now = queue.poll();

                for (Integer tmp : arr.get(now)) {
                    if (chk[tmp]) continue;

                    queue.offer(tmp);
                    chk[tmp] = true;
                    parent[tmp] = now;
                }
            }
        }
    }
}
