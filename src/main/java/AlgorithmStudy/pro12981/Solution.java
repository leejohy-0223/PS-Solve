package AlgorithmStudy.pro12981;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int num = 1;
        Set<String> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        char beforeEnd = words[0].charAt(0);
        for (String word : words) {
            if (set.contains(word) || word.charAt(0) != beforeEnd) {
                return new int[] {num, map.getOrDefault(num, 0) + 1};
            }
            set.add(word);
            map.put(num, map.getOrDefault(num, 0) + 1);
            num = (num == n) ? 1 : num + 1;
            beforeEnd = word.charAt(word.length() - 1);
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(2,
            new String[] {"ab", "cc", "cd", "de", "eg"});

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
