package barkingDog.LinkedList0x04.boj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        int count = 1;
        while (!queue.isEmpty()) {
            if (count == K) {
                count = 1;
                result.add(queue.poll());
            } else {
                count++;
                queue.offer(queue.poll());
            }
        }
        System.out.println(result.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "<", ">")));

    }
}
