package barkingDog.Deque0x07.boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> deque = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int result = 0;
        while (st.hasMoreTokens()) {
            Integer curValue = Integer.parseInt(st.nextToken());
            if (deque.indexOf(curValue) == 0) {
                deque.remove(curValue);
                continue;
            }
            if (deque.indexOf(curValue) <= deque.size() / 2) {
                while (!deque.get(0).equals(curValue)) {
                    deque.add(deque.remove(0));
                    result++;
                }
                deque.remove(curValue);
                continue;
            }
            while (!deque.get(0).equals(curValue)) {
                deque.add(0, deque.remove(deque.size() - 1));
                result++;
            }
            deque.remove(curValue);
        }
        System.out.println(result);
    }
}
