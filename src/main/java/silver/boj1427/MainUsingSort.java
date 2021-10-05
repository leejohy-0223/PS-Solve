package silver.boj1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainUsingSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] list = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            list[i] = Character.getNumericValue(s.charAt(i));
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if(list[i] < list[j]) {
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
        for (int i : list) {
            System.out.print(i);
        }
    }
}
