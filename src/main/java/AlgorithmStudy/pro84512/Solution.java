package AlgorithmStudy.pro84512;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int[] numbers = {781, 156, 31, 6, 1};
    public int solution(String word) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            result += (1 + (map.get(chars[i])) * numbers[i]);
        }
        return result;
    }
}
