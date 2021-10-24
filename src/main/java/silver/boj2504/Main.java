package silver.boj2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int l;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chars = br.readLine().toCharArray();
        l = chars.length;

        int result = 0;

        Stack<Character> fck = new Stack<>();

        for (int i = 0; i < l; i++) {
            if (chars[i] == '[' || chars[i] == '(') {
                fck.push(chars[i]);
                continue;
            }

            if (chars[i] == ']' || chars[i] == ')') {
                if (fck.isEmpty()) {
                    System.out.println(0);
                    return;
                }
            }
            if (chars[i] == ']') {
                if (fck.pop() != '[') {
                    break;
                }
            } else if (chars[i] == ')') {
                if (fck.pop() != '(') {
                    break;
                }
            }
        }

        if (fck.size() != 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < l; ) {
            if (chars[i] == '(' || chars[i] == '[') {
                int eIdx = findEndIdx(i, chars[i]);
                result += rangeOperation(i, eIdx, chars[i]);
                i = eIdx + 1;
            } else
                i++;
        }
        System.out.println(result);
    }

    private static int rangeOperation(int start, int end, char aChar) {
        if (aChar == ')' || aChar == ']') return 0;

        if (end == start + 1) {
            if (chars[end] == ')') {
                return 2;
            } else
                return 3;
        }

        int result = 0;
        for (int j = start + 1; j < end; ) {
            if (chars[j] == '(' || chars[j] == '[') {
                int e = findEndIdx(j, chars[j]);
                result += rangeOperation(j, e, chars[j]);
                j = e + 1;
            } else
                j++;
        }

        if (aChar == '(') {
            return 2 * result;
        } else
            return 3 * result;
    }

    private static int findEndIdx(int i, char aChar) {
        Stack<Character> stack = new Stack<>();
        stack.push(aChar);

        int endIdx = i + 1;
        while (!stack.isEmpty()) {

            if (chars[endIdx] == aChar) {
                stack.push(aChar);
                endIdx++;
                continue;
            }

            if ((aChar == '(' && chars[endIdx] == ')') || (aChar == '[' && chars[endIdx] == ']')) {
                stack.pop();
            }
            endIdx++;
        }

        return --endIdx;
    }
}
