package programmers.pro81303;

import java.util.*;

class SolutionRef {
    public String solution(int n, int k, String[] cmd) {

        Stack<Integer> bin = new Stack<>();

        int size = n;
        for (String command : cmd) {
            char c = command.charAt(0);
            if (c == 'D') {
                k += Integer.parseInt(command.substring(2));
            } else if (c == 'U') {
                k -= Integer.parseInt(command.substring(2));
            } else if (c == 'C') {
                bin.add(k);
                size--;
                if (k == size) {
                    k--;
                }
            } else {
                if (bin.pop() <= k) {
                    k++;
                }
                size++;
            }
        }
        StringBuilder sb = new StringBuilder("O".repeat(size));

        while (!bin.isEmpty()) {
            sb.insert(bin.pop().intValue(), 'X');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();

        System.out.println(
            s.solution(8, 2, new String[] {"C", "C", "C", "C", "C", "C", "C"}));

        // System.out.println(
        //     s.solution(8, 2, new String[] {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
        // StringBuilder sb = new StringBuilder();
        //
        // sb.insert(1, 'X');
        // System.out.println(sb);
    }
}
