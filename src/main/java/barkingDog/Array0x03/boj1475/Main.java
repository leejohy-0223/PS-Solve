package barkingDog.Array0x03.boj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] freq = new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        for (char c : number.toCharArray()) {
            if (c == '9') {
                freq[6] ++;
                continue;
            }
            freq[c - '0']++;
        }
        int maxValue = Arrays.stream(freq).max().getAsInt();

        if (maxValueIsOnlySix(maxValue, number)) {
            if (maxValue % 2 == 0) {
                System.out.println(maxValue / 2);
            } else {
                System.out.println(maxValue / 2 + 1);
            }
        } else {
            System.out.println(maxValue);
        }
    }

    private static boolean maxValueIsOnlySix(int maxValue, String number) {
        int count = 0;
        for (int i : freq) {
            if (i == maxValue) {
                count++;
            }
        }
        return count == 1 && freq[6] == maxValue;
    }
}
