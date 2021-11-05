package programmers.newsClustering;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution {
    static ArrayList<String> chk = new ArrayList<>();
    private static final String ALPHABET_REGULAR = "^[a-zA-Z]*$";

    public int solution(String str1, String str2) {
        int answer = 65536;

        // 1. A, B 집합 각각 만들기.
        ArrayList<String> arr1 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            boolean matches = Pattern.matches(ALPHABET_REGULAR, tmp);
            if (!matches) continue;
            tmp = tmp.toLowerCase();
            arr1.add(tmp);
        }

        ArrayList<String> arr2 = new ArrayList<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            boolean matches = Pattern.matches(ALPHABET_REGULAR, tmp);
            if (!matches) continue;
            tmp = tmp.toLowerCase();
            arr2.add(tmp);
        }
        System.out.println("arr1.size() = " + arr1.size());
        System.out.println("arr2.size() = " + arr2.size());
        if (arr1.size() == 0 && arr2.size() == 0) { // 둘 다 0이면 65536 반환
            return answer;
        } else if(arr1.size() == 0 || arr2.size() == 0){ //둘중 하나만 0이면, 교집합이 없으므로 0을 반환
            return 0;
        }

        // A기준으로 B와 비교하기
        int acount;
        int bcount;
        double kyo = 0, hap = 0;

        for (String s : arr1) {
            if (chk.contains(s)) continue;
            chk.add(s);
            // s의 개수를 처음 계산하기
            acount = 0;
            for (String s1 : arr1) {
                if (s1.equals(s)) {
                    acount++;
                }
            }

            // arr2에도 포함된다면 개수 계산하기
            if (arr2.contains(s)) {
                bcount = 0;
                // arr2에서도 s수 계산
                for (String s1 : arr2) {
                    if (s1.equals(s)) {
                        bcount++;
                    }
                }
            } else { // arr2에 포함되지 않은 값은 hap에만 넣기
                hap += acount;
                continue;
            }

            // 둘 중 작은 값은 교집합에 더하기
            kyo += Math.min(acount, bcount);

            // 큰 값은 합집합에 더하기
            hap += Math.max(acount, bcount);
        }

        // A에서 탐색되지 않은 값이라면 b에만 있는거이므로, hap만 갱신하면 된다.
        for (String s : arr2) {
            if(chk.contains(s)) continue;
            chk.add(s);
            bcount = 0;

            for (String s1 : arr2) {
                if (s.equals(s1)) {
                    bcount++;
                }
            }

            hap += bcount;
        }

        double d = kyo / hap * 65536;
        answer = (int) d;
        return answer;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution("hand@Sha ke", "shake Hands"));
//        System.out.println(s.solution("FRANCE", "FRENCH"));
        System.out.println(s.solution("E=M*C^2", "e=m*c^2"));


    }
}
