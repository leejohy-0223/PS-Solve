package bronze.boj2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = {'D', 'C', 'B', 'A', 'E'};

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            int count = 0;
            for (int j = 0; j < s.length(); j+=2) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
            System.out.println(arr[count]);
        }
    }
}
