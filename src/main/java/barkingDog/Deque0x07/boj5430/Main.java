package barkingDog.Deque0x07.boj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String p;
        int n;
        Deque<Integer> deque;
        String arr;
        boolean direction; // true : 정방향, false : 역방향

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            direction = true;
            arr = br.readLine();
            String[] tmpSplit = arr.substring(1, arr.length() - 1).split(",");
            for (String s : tmpSplit) {
                if(!s.equals("")) {
                    deque.add(Integer.parseInt(s));
                }
            }
            boolean erChk = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    direction = !direction;
                    continue;
                }
                if (c == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error").append("\n");
                        erChk = true;
                        break;
                    }
                    // 정방향
                    if (direction) {
                        deque.pollFirst();
                    } else
                        deque.pollLast();
                }
            }
            if (erChk) {
                continue;
            }

            // array를 sb에 붙이기
            if (!direction) {
                sb.append(deque.stream()
                    .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream();
                        }))
                    .map(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"))).append("\n");
            } else {
                sb.append(deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"))).append("\n");
            }

        }
        System.out.println(sb);

    }
}
