package gold.boj1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] chk;
    static int[] color;
    static boolean checkBipartite; // 이분 그래프인지 여부 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {

            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 매 테스트마다 모두 초기화 필요
            arr = new ArrayList<>();
            chk = new boolean[V + 1];
            color = new int[V + 1];
            checkBipartite = true;


            for (int i = 0; i <= V; i++) {
                arr.add(new ArrayList<>());
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                arr.get(n1).add(n2);
                arr.get(n2).add(n1);
            }

            for (int i = 1; i <= V ; i++) {
                if(!chk[i]) {
                    chk[i] = true;
                    color[i] = 1;
                    BFS(i);
                }
            }

            if (checkBipartite) {
                sb.append("YES").append("\n");
            } else
                sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer tmp : arr.get(poll)) {
                if(!chk[tmp]) {
                    chk[tmp] = true;
                    color[tmp] = -color[poll];
                    queue.offer(tmp);
                    continue;
                }
                // chk 된거라면 인접한 노드와 색깔 확인, 같으면 false
                if(color[poll] == color[tmp]) {
                    checkBipartite = false;
                    return;
                }
            }
        }
    }
}
