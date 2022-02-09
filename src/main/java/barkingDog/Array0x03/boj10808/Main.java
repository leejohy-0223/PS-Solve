package barkingDog.Array0x03.boj10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] freq = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (char c : input.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i : freq) {
            System.out.print(i + " ");
        }
    }

}
