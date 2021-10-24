package silver.boj5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            arr.get(f1).add(f2);
            arr.get(f2).add(f1);
        }

        list.add(1);
        BFS(1);

        System.out.println(list.size() - 1);
    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        int depth = 2;
        while (!queue.isEmpty() && depth > 0) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer poll = queue.poll();
                ArrayList<Integer> arrayList = arr.get(poll);

                for (Integer integer : arrayList) {
                    if (!list.contains(integer)) {
                        list.add(integer);
                        queue.offer(integer);
                    }
                }
            }
            depth--;
        }

    }
}
