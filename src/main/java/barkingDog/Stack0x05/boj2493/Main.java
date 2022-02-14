package barkingDog.Stack0x05.boj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

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
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        int[] result = new int[N + 1];

        stack.push(new Node(Integer.parseInt(st.nextToken()), 1));

        for (int i = 2; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < value) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek().idx;
            }
            stack.push(new Node(value, i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
