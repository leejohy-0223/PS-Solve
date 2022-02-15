package barkingDog.Stack0x05.boj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MainUsingMonotone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() > input) {
                    break;
                }
                stack.pop();
            }
            result += stack.size();
            stack.push(input);
        }

        System.out.println(result);

    }
}
