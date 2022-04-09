package programmers.test3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String solution(String tstring, String[][] variables) {

        Map<String, String> map = new HashMap<>();
        for (String[] variable : variables) {
            map.put(variable[0], variable[1]);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder var;
        for (int i = 0; i < tstring.length(); i++) {

            if (tstring.charAt(i) == '{') {
                var = new StringBuilder();

                // 이 로직 끝나고 i값 변경 필요!
                for (int j = i + 1; j < tstring.length(); j++) {
                    if (tstring.charAt(j) == '}') {
                        i = j;
                        break;
                    }
                    var.append(tstring.charAt(j));
                }

                // 끝('}')을 만났고,
                // 키를 가지고 있다면 변형
                String templateVariable = var.toString();
                if (map.containsKey(templateVariable)) {

                    String value = map.get(templateVariable);

                    // 순수 값이라면 바로 result에 추가한다.
                    if (!value.contains("{")) {
                        result.append(value);
                    }

                    // 이 값도 template이면 또 검사를 진행한다.
                    if (value.contains("{")) {
                        Set<String> usedKey = new HashSet<>();
                        // usedKey.add(templateVariable);
                        while (true) {
                            String nKey = value.substring(1, value.length() - 1);

                            // 주요 맵에 새로운 key가 없으면 끝낸다.
                            if (!map.containsKey(nKey)) {
                                result.append(value);
                                break;
                            }

                            // 이전에 사용된 키라면 끝낸다.
                            if (usedKey.contains(nKey)) {
                                // 계속 반복될 것이므로, 변형 안 된 상태로 넣는다.
                                result.append("{").append(templateVariable).append("}");
                                // result.append(map.get(nKey));
                                break;
                            }

                            // 새로운 값을 받아온다.
                            usedKey.add(nKey);
                            String nValue = map.get(nKey);

                            // 새로운 값이 순수값이면 더하고 끝낸다.
                            if (!nValue.contains("{")) {
                                result.append(nValue);
                                break;
                            }

                            // 또 괄호 있으면 키에 넣고 while 반복한다.
                            value = nValue;
                        }
                    }
                } else {
                    // 해당 키가 없다면,
                    result.append("{").append(templateVariable).append("}");
                    System.out.println("templateVariable = " + templateVariable);
                }
            } else {
                result.append(tstring.charAt(i));
            }
        }
        System.out.println(result);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // s.solution("this is {template} {template} is {state}",
        //     new String[][] {{"template", "string"}, {"state", "changed"}});

        // s.solution("this is {template} {template} is {state}",
        //     new String[][] {{"template", "string"}, {"state", "{template}"}});

        // s.solution("this is {template} {template} is {state}",
        //     new String[][] {{"template", "{state}"}, {"state", "{template}"}});

        // s.solution("this is {template} {template} is {state}",
        //     new String[][] {{"template", "{state}"}, {"state", "{templates}"}});

        s.solution("{a} {b} {c} {d} {i}",
            new String[][] {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}});
    }
}
