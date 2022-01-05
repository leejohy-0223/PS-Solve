package bronze.boj10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder numA = new StringBuilder(st.nextToken());
        StringBuilder numB = new StringBuilder(st.nextToken());

        // 길이 맞추기
        if(numA.length() != numB.length()) {
            int maxL = Math.max(numA.length(), numB.length());
            if (numA.length() == maxL) {
                extendLength(numB, maxL);
            } else {
                extendLength(numA, maxL);
            }
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int tempA, tempB, tempResult;
        for (int i = numA.length() - 1; i >= 0; i--) {
            tempA = numA.charAt(i) - '0';
            tempB = numB.charAt(i) - '0';
            tempResult = tempA + tempB + carry;
            if (tempResult > 9) {
                carry = 1;
                result.append(tempResult % 10);
            } else {
                carry = 0;
                result.append(tempResult);
            }
        }
        if (carry == 1) {
            result.append(1);
        }
        System.out.println(result.reverse());
    }

    private static void extendLength(StringBuilder num, int maxL) {
        int extendL;
        extendL = maxL - num.length();
        for (int i = 0; i < extendL; i++) {
            num.insert(0, "0");
        }
    }
}
