package barkingDog.Array0x03.boj1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        String s1 = br.readLine();
        String s2 = br.readLine();

        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            arr2[c - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            result += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println(result);
    }
}
