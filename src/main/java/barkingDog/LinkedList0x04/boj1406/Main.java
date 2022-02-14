package barkingDog.LinkedList0x04.boj1406;

// 시간 초과 코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        int N = Integer.parseInt(br.readLine());
        List<Character> list = new ArrayList<>();
        int idx = init.length() - 1;
        for (char c : init.toCharArray()) {
            list.add(c);
        }

        String command;

        while (N-- > 0) {
            command = br.readLine();
            if (command.contains("P")) {
                char insertValue = command.charAt(2);
                list.add(++idx, insertValue);
                continue;
            }
            if (command.equals("L") && idx != -1) {
                idx--;
                continue;
            }
            if (command.equals("D") && (idx != list.size() - 1)) {
                idx++;
                continue;
            }
            if (command.equals("B") && idx != -1) {
                list.remove(idx--);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
