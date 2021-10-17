package gold.boj2448;

import java.io.*;

public class Main {
    static String[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        map = new String[3];

        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";

        for (int k = 0; k <= 11; k++) {
            makeStar(k);
            if ((int) (3 * Math.pow(2, k)) == N) {
                break;
            }
        }

        for (String s : map) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void makeStar(int k) {

        if (k == 0) {
            return;
        }

        int size = (int) (3 * Math.pow(2, k));
        String[] nMap = new String[size];

        // 양옆 공백 용
        int empty = size / 2;

        StringBuilder sb = new StringBuilder();

        // 이전 값 + 공백 넣기
        for (int i = 0; i < map.length; i++) {
            sb.append(" ".repeat(empty));
            sb.append(map[i]);
            sb.append(" ".repeat(empty));
            nMap[i] = sb.toString();
            sb = new StringBuilder();
        }

        // 새로운 인덱스부터 추가하기
        for (int i = map.length; i < size; i++) {
            sb.append(map[i - empty]).append(" ").append(map[i - empty]);
            nMap[i] = sb.toString();
            sb = new StringBuilder();
        }

        map = nMap.clone();
    }
}
