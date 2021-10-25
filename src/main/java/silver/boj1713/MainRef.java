package silver.boj1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainRef {

    static class Pair implements Comparable<Pair> {

        int val, up, day;

        public Pair(int val, int up, int day) {
            this.val = val;
            this.up = up;
            this.day = day;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.up == o.up) {
                return this.day - o.day;
            }
            return this.up - o.up;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (Pair pair : list) {
                if (pair.val == num) {
                    flag = true;
                    pair.up++;
                    break;
                }
            }
            // 같은게 없었다면,
            if (!flag) {
                // 프레임이 꽉 찼다면,
                if (list.size() == N) {
                    list.remove(0); // 이게 맞나?
                    list.add(new Pair(num, 1, i));
                } else { // 꽉 안찼다면
                    list.add(new Pair(num, 1, i));
                }
            }
            Collections.sort(list);
        }

        list.sort(Comparator.comparingInt(o -> o.val));

        for (Pair pair : list) {
            System.out.print(pair.val + " ");
        }
    }
}
