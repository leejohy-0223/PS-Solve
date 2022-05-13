package codingTest.sg.p1;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] v, int a, int b) {
        List<Integer> list = Arrays.stream(v)
            .boxed().sorted().collect(Collectors.toList());

        Integer max = Collections.max(list);

        int count = 0;
        int minValue, maxValue;
        while (true) {
            minValue = list.get(0);
            maxValue = list.get(list.size() - 1);

            if (maxValue < a || minValue < b) {
                return count;
            }
            count++;
            for (int i = 0; i < list.size() - 1; i++) {
                list.set(i, list.get(i) - b);
            }

            list.set(list.size() - 1, maxValue - a);
            Collections.sort(list);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int solution = s.solution(new int[] {4, 5, 5}, 2, 1); // 3
        int solution = s.solution(new int[] {4, 4, 3}, 2, 1); // 2
        System.out.println(solution);
    }
}
