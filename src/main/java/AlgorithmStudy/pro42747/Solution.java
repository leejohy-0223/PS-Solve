package AlgorithmStudy.pro42747;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : citations) {
            list.add(i);
        }
        list.sort(Collections.reverseOrder());
        int tmpCount;
        while (true) {
            tmpCount = 0;
            for (Integer value : list) {
                if (value < answer) {
                    break;
                }
                tmpCount++;
            }
            if (tmpCount < answer) {
                return answer - 1;
            }
            answer++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {3, 0, 6, 1, 5}));
    }
}
