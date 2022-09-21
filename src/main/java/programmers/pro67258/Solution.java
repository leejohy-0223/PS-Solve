package programmers.pro67258;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> maps = new HashMap<>();
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int allSize = gemSet.size();
        List<Index> results = new ArrayList<>();

        int left = 0, right = 0;
        while (right < gems.length) {
            maps.put(gems[right], maps.getOrDefault(gems[right], 0) + 1);

            while (maps.keySet().size() == allSize) {
                maps.put(gems[left], maps.get(gems[left]) - 1);
                if (maps.get(gems[left]) == 0) {
                    maps.remove(gems[left]);
                }
                results.add(new Index(left, right));
                left += 1;
            }
            right += 1;
        }

        results.sort((o1, o2) -> {
            if (o1.getSize() == o2.getSize()) {
                return o1.left - o2.left;
            }
            return o1.getSize() - o2.getSize();
        });

        Index tmp = results.get(0);

        return new int[] {tmp.left + 1, tmp.right + 1};
    }

    static class Index {
        private int left;
        private int right;

        public Index(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getSize() {
            return right - left;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
            Arrays.toString(
                s.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }
}
