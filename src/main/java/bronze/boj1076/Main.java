package bronze.boj1076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, List<String>> resMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        resMap = new HashMap<>();

        resMap.put("black", List.of("0", ""));
        resMap.put("brown", List.of("1", "0"));
        resMap.put("red", List.of("2", "00"));
        resMap.put("orange", List.of("3", "000"));
        resMap.put("yellow", List.of("4", "0000"));
        resMap.put("green", List.of("5", "00000"));
        resMap.put("blue", List.of("6", "000000"));
        resMap.put("violet", List.of("7", "0000000"));
        resMap.put("grey", List.of("8", "00000000"));
        resMap.put("white", List.of("9", "000000000"));

        StringBuilder sb = new StringBuilder();
        String currentColor;
        for (int i = 0; i < 2; i++) {
            currentColor = br.readLine();
            sb.append(resMap.get(currentColor).get(0));
        }
        String lastColor = br.readLine();
        String result = sb.append(resMap.get(lastColor).get(1)).toString();

        System.out.println(Long.parseLong(result));
    }
}
