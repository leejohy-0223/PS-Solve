package barkingDog.Stack0x05.boj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int height;
    int idx;

    public Node(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        long result = 0;
        int count;
        int lastIdx;
        stack.push(new Node(list.get(list.size() - 1), list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            int curValue = list.get(i);
            count = 0;
            while (!stack.isEmpty() && curValue > stack.peek().height) {
                count++;
                lastIdx = stack.pop().idx;
                arr[i] += arr[lastIdx];
            }
            arr[i] += count;
            stack.push(new Node(curValue, i));
        }

        for (long i : arr) {
            result += i;
        }

        System.out.println(result);
    }
}
