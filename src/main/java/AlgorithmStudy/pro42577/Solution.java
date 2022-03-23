package AlgorithmStudy.pro42577;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (String s : phone_book) {
            System.out.println(s);
        }
        Set<String> set = new HashSet<>();
        for (String number : phone_book) {
            for (int i = 1; i <= number.length(); i++) {
                String substring = number.substring(0, i);
                if (set.contains(substring)) {
                    return false;
                }
            }
            set.add(number);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[] {"0", "030","932", "23412", "34214", "012", "0100", "011"}));
    }
}
