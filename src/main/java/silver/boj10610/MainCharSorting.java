package silver.boj10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainCharSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        Arrays.sort(N);
        if(N[0]!='0'){
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for(int i=0; i<N.length; i++) {
            sum += N[i] - '0';
        }
        if(sum % 3 != 0) System.out.println(-1);
        else System.out.println(new StringBuilder(String.valueOf(N)).reverse());
        br.close();
    }
}
