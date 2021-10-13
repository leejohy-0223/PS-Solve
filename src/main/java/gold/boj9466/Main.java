package gold.boj9466;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] bfsChk;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            bfsChk = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if(!bfsChk[i]) {
                    bfsChk[i] = true;
//                    BFS(i);
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    DFS(i, list);
                }
            }
            bw.write(count +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void DFS(int i, List<Integer> list) {

        int temp = arr[i];

        if(list.contains(temp)) {
            count += list.indexOf(temp);
            return;
        }

        if(bfsChk[temp]) {
            count += list.size();
            return;
        }

        list.add(temp);
        bfsChk[temp] = true;
        DFS(temp, list);
    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(i);
        list.add(i);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int temp = arr[poll];

            if(list.contains(temp)) {
                count += list.indexOf(temp);
                return;
            }

            if(bfsChk[temp]) {
                count += list.size();
                return;
            }

            list.add(temp);
            bfsChk[temp] = true;
            queue.offer(temp);
        }
    }
}
