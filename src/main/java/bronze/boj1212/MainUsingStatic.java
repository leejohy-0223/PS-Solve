package bronze.boj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainUsingStatic {
    static String[] eight = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int ln = input.length();
        boolean flag = false;
        if (input.equals("0")) {
            System.out.println("0");
        } else {
            for (int i = 0; i < ln; i++) {
                int before = input.charAt(i) - '0';
                if (!flag && before < 4) {
                    // 처음 요소 검사
                    if (before == 0) {
                        continue;
                    } else if (before == 1) {
                        sb.append("1");
                    } else if (before == 2) {
                        sb.append("10");
                    } else if (before == 3) {
                        sb.append("11");
                    }
                    flag = true;    // 처음 요소 검사 탈출
                } else {
                    sb.append(eight[before]);
                    flag = true;    // 처음 요소 검사 탈출
                }
            }
        }
        System.out.println(sb.toString());
    }
}
