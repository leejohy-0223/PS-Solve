package programmers.kakao.p1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new LinkedHashMap<>();
        scoreMap.put('R', 0);
        scoreMap.put('T', 0);
        scoreMap.put('C', 0);
        scoreMap.put('F', 0);
        scoreMap.put('J', 0);
        scoreMap.put('M', 0);
        scoreMap.put('A', 0);
        scoreMap.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            char firstValue = s.charAt(0);
            char secondValue = s.charAt(1);

            int choice = choices[i];
            if (choice == 4) {
                continue;
            }

            if (choice < 4) {
                int scoreForFirst = 4 - choice;
                scoreMap.put(firstValue, scoreMap.get(firstValue) + scoreForFirst);
            } else {
                int scoreForSecond = choice - 4;
                scoreMap.put(secondValue, scoreMap.get(secondValue) + scoreForSecond);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Character> compareList = new ArrayList<>();
        for (Character key : scoreMap.keySet()) {
            if (compareList.size() != 1) {
                compareList.add(key);
                continue;
            }
            compareList.add(key);
            Character c1 = compareList.get(0);
            Character c2 = compareList.get(1);
            if (scoreMap.get(c1) < scoreMap.get(c2)) {
                sb.append(c2);
            } else {
                sb.append(c1);
            }
            compareList = new ArrayList<>();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String solution = s.solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5});
        System.out.println(solution);
    }
}
