package DongBinBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Chap6_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];

        init(br, N, arrA);
        init(br, N, arrB);

        Arrays.sort(arrA);

        List<Integer> list = Arrays.asList(arrB);
        list.sort(Collections.reverseOrder());
        arrB = list.toArray(new Integer[0]);

        int idx = 0;
        while (K-- > 0) {
            if (arrA[idx] >= arrB[idx]) {
                break;
            }
            arrA[idx] = arrB[idx];
            idx++;
        }
        System.out.println(Arrays.stream(arrA)
            .mapToInt(Integer::intValue).sum());

    }

    private static void init(BufferedReader br, int N, Integer[] arrA) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
    }

}
