package AlgorithmStudy.pro42577;

import java.util.Arrays;
import java.util.HashSet;

public class SolutionRef {
    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(phone_book));

        for (String h : hs) {
            System.out.println(h);
        }
        for (String s : phone_book) {
            for (int j = 1; j < s.length(); j++) {
                if (hs.contains(s.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolutionRef solutionRef = new SolutionRef();
        System.out.println(solutionRef.solution(new String[] {"0", "030","932", "23412", "34214", "012", "0100", "011"}));
    }
}
