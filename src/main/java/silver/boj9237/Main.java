package silver.boj9237;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Integer[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree, Collections.reverseOrder());
        int max = 0;
        for (int i = 0; i < N; i++) {//나무 자라는 일수+심는데 흐른 일수
            tree[i] = tree[i] + i + 1;
            if (tree[i] > max)
                max = tree[i];
        }
        System.out.println(max + 1);//1일에는 묘목 구매했음

    }

}
