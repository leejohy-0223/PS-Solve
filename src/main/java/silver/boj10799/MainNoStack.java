package silver.boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainNoStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        int result = 0;
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(') {
                if(charArray[i+1] == ')') {
                    result += count;
                    i++;
                    continue;
                }
                count++;
            } else {
                result += 1;
                count -= 1;
            }
        }
        System.out.println(result);

    }
}
