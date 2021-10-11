package silver.boj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();

        for (char c : charArray) {
            deque.offer(c);
        }

        while (M-- > 0) {
            String get = br.readLine();
            if (get.equals("L")) {
                if(!deque.isEmpty()) {
                    Character pollLast = deque.pollLast();
                    deque2.offerFirst(pollLast);
                }
                continue;
            }

            if (get.equals("D")) {
                if(!deque2.isEmpty()) {
                    Character poll = deque2.pollFirst();
                    deque.offerLast(poll);
                }
                continue;
            }

            if (get.equals("B")) {
                if(!deque.isEmpty()) {
                    deque.pollLast();
                }
                continue;
            }
            char c = get.charAt(2);
            deque.offerLast(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        while(!deque2.isEmpty()) {
            sb.append(deque2.pollFirst());
        }

        System.out.println(sb);
    }
}
