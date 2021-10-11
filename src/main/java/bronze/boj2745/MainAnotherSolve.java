package bronze.boj2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainAnotherSolve {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        String a = s[0];

        int b = Integer.parseInt(s[1]);
        int r;
        double d = 0;
        int cnt = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            r = a.charAt(cnt ++) - '0';
            if(r > 10) {
                r -= 7;
            }
            d += Math.pow(b , i)* r;
        }
        System.out.println((int)d);
    }
}
