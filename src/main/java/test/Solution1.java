package test;

import java.util.Arrays;

public class Solution1 {

    public String solution(String[] registered_list, String new_id) {

        Arrays.sort(registered_list);
        int div = getDivide(new_id);
        String substring = new_id.substring(0, div);

        for (String s : registered_list) {
            System.out.println(s);
        }

        int first = 0;
        int last = registered_list.length;
        for (int i = 0; i < registered_list.length; i++) {
            if (registered_list[i].contains(substring)) {
                first = i;
                break;
            }
        }

        for (int i = first; i < registered_list.length; i++) {
            if (!registered_list[i].contains(substring)) {
                last = i;
                System.out.println(i);
                break;
            }
        }

        while (true) {
            boolean chk = false;

            for (int i = first; i < last; i++) {
                if (registered_list[i].equals(new_id)) {
                    chk = true;
                    break;
                }
            }

            if (!chk) { // false면 없는 id이므로 return
                System.out.println(new_id);
                return new_id;
            }

            int divide = getDivide(new_id);

            int n = 0;
            if (divide != 0) {
                n = Integer.parseInt(new_id.substring(divide));
            }

            n++;
            if (divide != 0) {
                new_id = new_id.substring(0, divide) + n;
            } else
                new_id = new_id + n;
        }
    }

    private int getDivide(String new_id) {
        char[] chars = new_id.toCharArray();

        int divide = 0;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                divide = i;
                break;
            }
        }
        return divide;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        String[] list1 = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        String new_id1 = "ace15";

        String[] list2 = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String new_id2 = "cow";

        String[] list3 = {"apple1", "orange", "banana3"};
        String new_id3 = "apple";

        String[] list4 = {"bird99", "bird98", "bird101", "gotoxy"};
        String new_id4 = "bird98";

//        s.solution(list1, new_id1);
//        s.solution(list2, new_id2);
//        s.solution(list3, new_id3);
        s.solution(list4, new_id4);
    }
}
