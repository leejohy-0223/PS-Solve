package bronze.boj1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] two = new int[] {2, 4, 8, 6};
    static int[] three = new int[] {3, 9, 7, 1};
    static int[] four = new int[] {4, 6};
    static int[] seven = new int[] {7, 9, 3, 1};
    static int[] eight = new int[] {8, 4, 2, 6};
    static int[] nine = new int[] {9, 1};

    static Map<Integer, int[]> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        map = new HashMap<>();
        map.put(2, two);
        map.put(3, three);
        map.put(4, four);
        map.put(7, seven);
        map.put(8, eight);
        map.put(9, nine);

        int n = Integer.parseInt(st.nextToken());
        int a, b;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(solve(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    private static int solve(int a, int b) {
        int idx;
        if (a % 10 == 0) {
            return 10;
        }
        while (a > 10) {
            a %= 10;
        }
        if (a == 1 || a == 5 || a == 6) {
            return a;
        }
        if (a == 4 || a == 9) {
            idx = (b + 1) % 2;
            return map.get(a)[idx];
        }
        idx = (b + 3) % 4;
        return map.get(a)[idx];
    }
}
