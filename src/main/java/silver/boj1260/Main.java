package silver.boj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static boolean[] chkNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
            Collections.sort(arr.get(n1));
            Collections.sort(arr.get(n2));
        }

        chkNode = new boolean[N+1];
        chkNode[V] = true;
        DFS(V);
        System.out.println(sb1);

        chkNode = new boolean[N+1];
        chkNode[V] = true;
        BFS(V);
        System.out.println(sb2);
    }


    private static void DFS(int v) {

        sb1.append(v).append(" ");

        for (Integer i : arr.get(v)) {
            if(!chkNode[i]) {
                chkNode[i] = true;
                DFS(i);
            }
        }
    }

    private static void BFS(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        chkNode[v] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            sb2.append(node).append(" ");

            for (Integer i : arr.get(node)) {
                if(!chkNode[i]) {
                    chkNode[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
