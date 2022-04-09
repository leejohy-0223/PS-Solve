package programmers.test1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] solution(String path) {
        char[] pathChar = path.toCharArray();
        int count = 1;
        char firstChar = pathChar[0];
        char nowChar;
        List<String> result = new ArrayList<>();

        int time = 1;
        for (int i = 1; i < pathChar.length; i++) {

            nowChar = pathChar[i];

            if (nowChar == firstChar) {
                count++;
            }

            if (nowChar != firstChar) {
                if (count < 5) {
                    result.add(
                        "Time " + (time - count) + ":" + " Go straight " + (count * 100) + "m and turn " + direction(
                            firstChar, nowChar));
                }
                if(count >= 5) {
                    result.add(
                        "Time " + (time - 5) + ":" + " Go straight 500m and turn " + direction(firstChar, nowChar));
                }


                firstChar = nowChar;
                count = 1;
            }
            time++;
        }
        return result.toArray(new String[0]);
    }

    private String direction(char firstChar, char nowChar) {
        if (firstChar == 'E') {
            if (nowChar == 'N') {
                return "left";
            }
            return "right";
        }
        if (firstChar == 'N') {
            if (nowChar == 'W') {
                return "left";
            }
            return "right";
        }
        if (firstChar == 'W') {
            if (nowChar == 'S') {
                return "left";
            }
            return "right";
        }
        if (nowChar == 'E') {
            return "left";
        }
        return "right";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] result = s.solution("EEESEEEEEENNNN");
        String[] result = s.solution("SSSSSSWWWNNNNNN");

        for (String s1 : result) {
            System.out.println(s1);
        }
    }
}
