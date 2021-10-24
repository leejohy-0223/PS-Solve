package silver.boj2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MainTest {

    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean f = false;
        long ans = 0;
        int val = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
                val *= 2;
                continue;
            }
            if (s.charAt(i) == '[') {
                stack.add('[');
                val *= 3;
                continue;
            }

            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    f = true;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    ans += val;
                }
                val /= 2;
                stack.pop();
                continue;
            }

            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    f = true;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    ans += val;
                }
                val /= 3;
                stack.pop();
            }
        }
        if (f || !stack.isEmpty()) {
            System.out.println(0);
        } else
            System.out.println(ans);

    }
}
