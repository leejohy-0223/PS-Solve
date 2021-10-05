package silver.boj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 1;
        for (int i = 0; i <= 8; i++) {
            map.put(i, 1);
        }
        map.put(6, 2);

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int numericValue = Character.getNumericValue(aChar);

            if (numericValue == 9) {
                numericValue = 6;
            }

            int value = map.get(numericValue);

            if (value > 0) {
                map.put(numericValue, value - 1);
                continue;
            }

            // value가 없을 경우 한 세트를 추가로 받아야 함
            count++;
            for (int i = 0; i <= 8; i++) {
                map.put(i, map.get(i) + 1);
            }
            map.put(6, map.get(6) + 1);

            // 세트를 받았으므로 다시 깎아야 함
            map.put(numericValue, map.get(numericValue) - 1);
        }
        System.out.println(count);
    }
}
