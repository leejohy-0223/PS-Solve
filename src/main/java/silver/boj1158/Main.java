package silver.boj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = 1;
        while (!queue.isEmpty()) {
            if(count == K) {
                sb.append(queue.poll() + ", ");
                count = 1;
                continue;
            }
            queue.offer(queue.poll());
            count++;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
