package AlgorithmStudy.boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] arr = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int mallfuncCount = Integer.parseInt(br.readLine());

        if (mallfuncCount > 0) {
            String[] split = br.readLine().split(" ");
            for (String s : split) {
                arr[Integer.parseInt(s)] = true;
            }
        }

        if (target == 100) {
            System.out.println(0);
            return;
        }

        if (mallfuncCount == 0) {
            System.out.println(Math.min(Math.abs(target - 100), String.valueOf(target).length()));
            return;
        }

        int minus_dir = target;
        int plus_dir = target;

        while (true) {
            if (minus_dir > 0) {
                minus_dir -= 1;
            }
            plus_dir += 1;

            boolean chk = true;
            for (char c : String.valueOf(minus_dir).toCharArray()) {
                if (arr[Integer.parseInt(c + "")]) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                System.out.println(Math.min(Math.abs(target - 100), Math.abs(target - minus_dir) + String.valueOf(minus_dir).length()));
                return;
            }

            chk = true;
            for (char c : String.valueOf(plus_dir).toCharArray()) {
                if (arr[Integer.parseInt(c + "")]) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                System.out.println(Math.min(Math.abs(target - 100), Math.abs(target - plus_dir) + String.valueOf(plus_dir).length()));
                return;
            }
        }
    }
}
