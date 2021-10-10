package silver.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String s = br.readLine();
            if(s.length() > 5) {
                String[] split = s.split(" ");
                int tmp = Integer.parseInt(split[1]);
                queue.offer(tmp);
                continue;
            }
            if (s.startsWith("pop")) {
                if(queue.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                Integer poll = queue.poll();
                sb.append(poll).append("\n");
                continue;
            }
            if(s.startsWith("front")) {
                if(queue.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(queue.peekFirst()).append("\n");
                continue;
            }
            if(s.startsWith("back")) {
                if(queue.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(queue.peekLast()).append("\n");
                continue;
            }
            if(s.startsWith("size")) {
                sb.append(queue.size()).append("\n");
                continue;
            }
            if(s.startsWith("empty")) {
                if(queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else
                    sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
