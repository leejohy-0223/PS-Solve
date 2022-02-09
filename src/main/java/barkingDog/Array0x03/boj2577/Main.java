package barkingDog.Array0x03.boj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = 1;

        for (int i = 0; i < 3; i++) {
            target *= Integer.parseInt(br.readLine());
        }

        String sTarget = String.valueOf(target);

        for (char c : sTarget.toCharArray()) {
            arr[c - '0']++;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
