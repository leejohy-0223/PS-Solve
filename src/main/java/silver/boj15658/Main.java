package silver.boj15658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static char[] tmp = {'+', '-', '*', '/'};
    static char[] use;
    static int N;
    static Character[] array;
    static boolean[] chk;
    static Set<String> set = new HashSet<>();
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        use = new char[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Character> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                list.add(tmp[i]);
            }
        }

        array = list.toArray(new Character[0]);
        chk = new boolean[array.length];
        permu(0);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void permu(int L) {
        if (L == N - 1) {
            // 연산 후 최대 & 최소 갱신
            StringBuilder sb = new StringBuilder();
            for (char c : use) {
                sb.append(c);
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                startOperate();
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if(!chk[i]) {
                use[L] = array[i];
                chk[i] = true;
                permu(L + 1);
                chk[i] = false;
            }
        }

    }

    private static void startOperate() {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            char c = use[i - 1];
            if (c == '+') {
                result += arr[i];
                continue;
            }
            if (c == '-') {
                result -= arr[i];
                continue;
            }
            if (c == '*') {
                result *= arr[i];
                continue;
            }
            if (c == '/') {
                result /= arr[i];
            }
        }
        minValue = Math.min(minValue, result);
        maxValue = Math.max(maxValue, result);
    }
}
