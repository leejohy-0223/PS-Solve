package barkingDog.Stack0x05.boj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int curValue = 1;
        int targetValue;

        while (idx != N) {
            targetValue = arr[idx++];
            while (targetValue >= curValue) {
                stack.push(curValue++);
                result.append("+").append("\n");
            }
            if (stack.peek() == targetValue) {
                stack.pop();
                result.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(result);
    }
}
