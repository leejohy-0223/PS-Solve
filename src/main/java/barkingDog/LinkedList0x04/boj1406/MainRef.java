package barkingDog.LinkedList0x04.boj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Deque<Character> list1 = new ArrayDeque<>();
        Deque<Character> list2 = new ArrayDeque<>();

        for (char c : init.toCharArray()) {
            list1.add(c);
        }

        String command;

        while (N-- > 0) {
            command = br.readLine();
            if (command.contains("P")) {
                list1.offerLast(command.charAt(2));
                continue;
            }
            if (command.equals("L")) {
                if(!list1.isEmpty()) {
                    list2.offerFirst(list1.pollLast());
                }
                continue;
            }
            if (command.equals("D")) {
                if(!list2.isEmpty()) {
                    list1.offerLast(list2.pollFirst());
                }
                continue;
            }
            if (command.equals("B")) {
                list1.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list1) {
            sb.append(c);
        }
        for (Character c : list2) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
