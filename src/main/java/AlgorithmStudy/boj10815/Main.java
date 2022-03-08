package AlgorithmStudy.boj10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] hadNumber;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        hadNumber = new int[N];

        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            hadNumber[i] = Integer.parseInt(numbers[i]);
        }

        Arrays.sort(hadNumber);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] target = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int targetNumber = Integer.parseInt(target[i]);
            sb.append(binarySearch(targetNumber)).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int targetNumber) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (targetNumber < hadNumber[mid]) {
                right = mid - 1;
                continue;
            }
            if (targetNumber > hadNumber[mid]) {
                left = mid + 1;
                continue;
            }
            return 1;
        }
        return 0;
    }
}
