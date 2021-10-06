package silver.boj10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int sum = 0;
        boolean chkZero = false;

        String[] split1 = s.split("");
        for (String s1 : split1) {
            int i = Integer.parseInt(s1);
            if(i == 0 && !chkZero) {
                chkZero = true;
            }
            sum += i;
        }

        if (!chkZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        String[] split = s.split("");
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String s1 : split) {
            pq.offer(Integer.parseInt(s1));
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb);
    }
}
