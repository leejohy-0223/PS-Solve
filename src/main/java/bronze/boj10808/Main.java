package bronze.boj10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        // 97 ~ 122
        char tmp = 'a';
        for (int i=0; i<26; i++) {
            map.put(tmp, 0);
            tmp += 1;
        }
        
        for (char aChar : chars) {
            map.put(aChar, map.get(aChar) + 1);
        }

        Set<Character> characters = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(map.get(c)).append(" ");
        }
        System.out.println(sb);
    }
}
