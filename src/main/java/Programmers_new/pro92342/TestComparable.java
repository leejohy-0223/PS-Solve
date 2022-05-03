package Programmers_new.pro92342;

import java.util.ArrayList;
import java.util.List;

public class TestComparable {
    static List<int[]> answers = new ArrayList<>();

    public static int[] solution() {
        int length = answers.get(0).length - 1;
        answers.sort(((o1, o2) -> {
            for (int i = length; i >= 0; i--) {
                if (o1[i] > o2[i]) {
                    System.out.println("return value is -1");
                    return -1; // 내림차순으로 정렬하기 위해, 뒤에 : o1[i]가 더 클 경우 자리를 바꾼다.
                }
                if (o1[i] < o2[i]) {
                    System.out.println("return value is 1");
                    return 1; // 내림차순으로 정렬하기 위해, 뒤에 : o1[i]가 더 작을 경우 유지한다.
                }
            }
            return 0;
        }));
        return null;
    }

    public static void main(String[] args) {
        // {1, 1, 2, 3, 5} o2
        // {0, 0, 1, 2, 3} o1
        // answers.add(new int[] {1, 1, 2, 1, 5});
        // answers.add(new int[] {1, 1, 2, 4, 5});
        // answers.add(new int[] {1, 1, 2, 5, 3});
        // answers.add(new int[] {1, 1, 2, 6, 2});
        answers.add(new int[] {1, 1, 0, 1, 0});
        answers.add(new int[] {1, 1, 0, 2, 0});
        // answers.add(new int[] {1, 3, 0, 0, 0});
        solution();

        for (int[] answer : answers) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
