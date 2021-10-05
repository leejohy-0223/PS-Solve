package silver.boj1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while (N-- > 0) {
            HashMap<Character, Boolean> map = new HashMap<>();
            char[] charArray = br.readLine().toCharArray();
            boolean chk = true;

            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if(map.containsKey(c)) {
                    if (charArray[i - 1] != c) {
                        chk = false;
                        break;
                    }
                }
                map.put(c, true);
            }
            if(chk) {
                result++;
            }
        }
        System.out.println(result);
    }
}
