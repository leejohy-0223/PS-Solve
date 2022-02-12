package barkingDog.Array0x03.boj13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] students = new int[2][7];
        int sex, year;
        int result = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            sex = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            if (students[sex][year] == 0) {
                result++;
                students[sex][year]++;
                continue;
            }
            if (students[sex][year] == K) {
                result++;
                students[sex][year] = 1;
                continue;
            }
            students[sex][year]++;
        }
        System.out.println(result);
    }
}
