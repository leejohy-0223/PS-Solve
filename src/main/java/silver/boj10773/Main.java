package silver.boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        while (n-- > 0) {
            int cur = Integer.parseInt(br.readLine());

            if (cur == 0) {
                stack.pop();
                continue;
            }
            stack.push(cur);
        }

        long result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
