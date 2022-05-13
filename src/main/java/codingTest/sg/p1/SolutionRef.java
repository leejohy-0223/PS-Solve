package codingTest.sg.p1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionRef {
    public int solution(int[] v, int a, int b) {

        Arrays.sort(v);

        int count = 0;
        int minValue = v[0];
        int maxValue;
        int maxIdx = v.length - 1;
        int L = v.length;

        while (true) {
            maxValue = v[maxIdx];
            if (maxValue < a || minValue < b) {
                return count;
            }
            count++;

            for (int i = 0; i < L - 1; i++) {
                v[i] -= b;
            }
            v[maxIdx] -= a;
            // 이 시점에 바로 이전값과 비교했을 때
        }
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        // int solution = s.solution(new int[] {4, 5, 5}, 2, 1); // 3
        int solution = s.solution(new int[] {4, 4, 3}, 2, 1); // 2
        System.out.println(solution);
    }
}
