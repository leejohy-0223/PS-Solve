package silver.boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        int result = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                if(charArray[i+1] == ')') {
                    result += stack.size();
                    i++;
                    continue;
                }
                stack.push('(');
            }
            if(charArray[i] == ')') {
                stack.pop();
                result += 1;
            }
        }
        System.out.println(result);
    }
}
