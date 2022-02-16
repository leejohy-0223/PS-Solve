package barkingDog.Stack0x05.boj17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    int idx;
    int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        int tmp;
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            tmp = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().value < tmp) {
                Node pop = stack.pop();
                arr[pop.idx] = tmp;
            }
            stack.push(new Node(idx++, tmp));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
