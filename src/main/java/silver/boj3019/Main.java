package silver.boj3019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static int c, p;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[c];
        for (int i = 0; i < c; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        makeBlock();
        System.out.println(result);
    }

    private static void makeBlock() {
        // block의 아랫쪽을 따진다.
        switch (p) {
            case 1:
                solve("0");
                solve("0000");
                break;
            case 2:
                solve("00");
                break;
            case 3:
                solve("001");
                solve("10");
                break;
            case 4:
                solve("100");
                solve("01");
                break;
            case 5:
                solve("000");
                solve("10");
                solve("101");
                solve("01");
                break;
            case 6:
                solve("011");
                solve("00");
                solve("000");
                solve("20");
                break;
            case 7:
                solve("110");
                solve("00");
                solve("000");
                solve("02");
                break;
        }
    }

    private static void solve(String s) {

        int len = s.length();
        for (int i = 0; i < c - len + 1; i++) {
            int min = 200;
            for (int j = i; j < i + len; j++) {
                min = Math.min(min, arr[j]);
            }
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + len; j++) {
                sb.append(arr[j] - min);
            }
            if (s.equals(sb.toString().trim())) {
                result++;
            }
        }
    }
}
