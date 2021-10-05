package silver.boj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] arr = new int[10];

        for (char aChar : chars) {
            arr[Character.getNumericValue(aChar)]++;
        }

        arr[6] = (arr[6] + arr[9] + 1) / 2;
        arr[9] = 0;

        int maxValue = Integer.MIN_VALUE;
        for (int i : arr) {
            maxValue = Math.max(maxValue, i);
        }
        System.out.println(maxValue);
    }
}
