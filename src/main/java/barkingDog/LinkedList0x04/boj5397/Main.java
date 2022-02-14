package barkingDog.LinkedList0x04.boj5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Character> frontDeq;
        Deque<Character> backDeq;

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String input = br.readLine();
            frontDeq = new ArrayDeque<>();
            backDeq = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if(!frontDeq.isEmpty()) {
                        backDeq.offerFirst(frontDeq.pollLast());
                    }
                    continue;
                }
                if (c == '>') {
                    if(!backDeq.isEmpty()) {
                        frontDeq.offerLast(backDeq.pollFirst());
                    }
                    continue;
                }
                if (c == '-') {
                    frontDeq.pollLast();
                    continue;
                }
                frontDeq.offerLast(c);
            }
            for (Character c : frontDeq) {
                sb.append(c);
            }
            for (Character c : backDeq) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
