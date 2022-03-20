package barkingDog.BFS0x09.boj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean[] chk = new boolean[100001];
        chk[N] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int result = 0;
        int[] calValue = new int[3];
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer now = queue.poll();
                calValue[0] = now + 1;
                calValue[1] = now - 1;
                calValue[2] = now * 2;
                for (int val : calValue) {
                    if (val == K) {
                        System.out.println(result);
                        return;
                    }
                    if (val >= 0 && val <= 100000 && !chk[val]) {
                        chk[val] = true;
                        queue.offer(val);
                    }
                }
            }
        }

    }
}
