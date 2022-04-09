package programmers.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String solution(String call) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = call.toCharArray();
        for (char aChar : chars) {
            char c = Character.toLowerCase(aChar);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxValue = 0;
        for (Character key : map.keySet()) {
            maxValue = Integer.max(maxValue, map.get(key));
        }

        for (Character key : map.keySet()) {
            if (map.get(key) == maxValue) {
                call = call.replaceAll("(?i)" + key, "");
            }
        }
        return call;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.solution("abxdeydeabz"));
        // System.out.println(s.solution("abcabcdefabc"));
        System.out.println(s.solution("abcabca"));
        System.out.println(s.solution("ABCabcA"));
    }

}
