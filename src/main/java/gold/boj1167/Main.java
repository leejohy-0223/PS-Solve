package gold.boj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Dist {
    int node;
    int distance;

    public Dist(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Main {

    static int v;
    static ArrayList<ArrayList<Dist>> arr = new ArrayList<>();

    static int result = Integer.MIN_VALUE;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                arr.get(idx).add(new Dist(node, distance));
                arr.get(node).add(new Dist(idx, distance));
            }
        }

        chk = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            chk[i] = true;
            int sum = 0;
            dfs(i, sum);
        }
        System.out.println(result);
    }

    private static void dfs(int n, int sum) {

        for (Dist dist : arr.get(n)) {
            if (!chk[dist.node]) {
                chk[dist.node] = true;
                sum += dist.distance;
                result = Math.max(result, sum);

                dfs(dist.node, sum);
                sum -= dist.distance;
            }
        }
    }
}
