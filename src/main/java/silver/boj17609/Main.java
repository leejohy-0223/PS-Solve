package silver.boj17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] arr;
    static boolean chkTwice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            arr = br.readLine().toCharArray();
            int left = 0;
            int right = arr.length - 1;
            chkTwice = false;
            if (palindrome(left, right)) {
                if (!chkTwice) {
                    sb.append(0).append("\n");
                } else
                    sb.append(1).append("\n");
            } else
                sb.append(2).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean palindrome(int left, int right) {
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else if (chkTwice) {
                return false;
            } else {
                // 양쪽 제거 후 다시 검사
                chkTwice = true;
                if (palindrome(left + 1, right)) {
                    return true;
                }

                if (palindrome(left, right - 1)) {
                    return true;
                }
                // 둘 다 아니라면 return false
                return false;
            }
        }
        return true;
    }

}
