package gold.boj1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int plus = 0;
        int minus = 0;
        int one = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > 0) {
                if (arr[i] == 1) {
                    one++;
                } else {
                    plus++;
                }
                continue;
            }
            if (arr[i] < 0) {
                minus++;
            }
        }

        Arrays.sort(arr);
        int divide = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                divide = i;
                break;
            }
        }
        if (minus != 0 && divide == 0) {
            divide = arr.length;
        }

        long result = 0;
        // 음수 부분 처리
        if (minus != 0) {
            // 짝수개로 묶을 수 있다면 묶어서 모두 없애기
            for (int i = 0; i < divide - 1; i += 2) {
                result += ((long) arr[i] * arr[i + 1]);
            }
            if (minus % 2 != 0) {
                result += arr[divide - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] > 1) break;
            if(arr[i] == 1) {
                divide = i;
                continue;
            }
            if (arr[i] < 1) {
                divide = i;
            }
        }

        // 양수 부분 처리
        if (plus != 0) {
            // 짝수개로 뒤에서 부터 묶어서 없애기
            for (int i = arr.length - 1; i > divide + 1; i -= 2) {
                result += ((long) arr[i] * arr[i - 1]);
            }
            if (plus % 2 != 0) {
                result += arr[divide + 1];
            }
        }

        if (one != 0) {
            result += one;
        }
        System.out.println(result);
    }
}
