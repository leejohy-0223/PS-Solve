package barkingDog.Array0x03.boj11328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String target, chk;
        int[] arr;
        StringBuilder result = new StringBuilder();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            target = st.nextToken();
            chk = st.nextToken();

            arr = new int[26];
            for (char c : target.toCharArray()) {
                arr[c - 'a']++;
            }

            for (char c : chk.toCharArray()) {
                arr[c - 'a']--;
            }

            boolean ckr = false;
            for (int i : arr) {
                if (i != 0) {
                    ckr = true;
                    break;
                }
            }
            if (ckr) {
                result.append("Impossible\n");
            } else
                result.append("Possible\n");
        }

        System.out.println(result);

    }
}
