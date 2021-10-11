package bronze.boj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if(aChar == '0') {
                sb.append("000");
                continue;
            }
            if(aChar == '1') {
                sb.append("001");
                continue;
            }
            if(aChar == '2') {
                sb.append("010");
                continue;
            }
            if(aChar == '3') {
                sb.append("011");
                continue;
            }
            if(aChar == '4') {
                sb.append("100");
                continue;
            }
            if(aChar == '5') {
                sb.append("101");
                continue;
            }
            if(aChar == '6') {
                sb.append("110");
                continue;
            }
            if(aChar == '7') {
                sb.append("111");
            }
        }
        if(chars[0] == '0') {
            System.out.println(0);
        }
        else if(chars[0] == '1') {
            System.out.println(sb.substring(2));
        } else if(chars[0] == '2' || chars[0] == '3') {
            System.out.println(sb.substring(1));
        } else
            System.out.println(sb);
    }
}
