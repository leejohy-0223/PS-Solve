package AlgorithmStudy.pro42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] strings = s.split(" ");
            String command = strings[0];
            if (command.equals("Leave")) {
                continue;
            }

            map.put(strings[1], strings[2]);
        }

        List<String> result = new ArrayList<>();
        for (String s : record) {
            String[] strings = s.split(" ");
            String command = strings[0];
            String userId = strings[1];
            String nickName = map.get(userId);

            if (command.equals("Enter")) {
                result.add(nickName + "님이 들어왔습니다.");
                continue;
            }
            if (command.equals("Leave")) {
                result.add(nickName + "님이 나갔습니다.");
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] solution = s.solution(
            new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" });

        for (String s1 : solution) {
            System.out.println(s1);
        }
    }

    // 119, 138

}
