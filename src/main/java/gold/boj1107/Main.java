package gold.boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] arr = new boolean[10];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //고장난게 true
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = true;
            }
        }

        int min_cnt = Math.abs(N - 100); // 우선 100에서 + 혹은 -를 눌러서 갈 수 있는 횟수를 계산한다.
        for (int i = 0; i <= 1000000; i++) { // 500000까지 입력되므로, 999999 -> 1000000까지 모두 다 살펴본다.
            int len = check(i); // 해당 값이 눌리는 경우라면, 순수하게 눌러서 갈 수 있는 횟수를 구한다.
            if (len > 0) { // 눌리는 경우가 맞다면, if를 실행한다.
                int tmp = Math.abs(N - i); // i에서 N까지 + / -로 갈 수 있는 횟수를 tmp에 저장한다.
                min_cnt = Math.min(min_cnt, tmp + len); // 기존에 저장된 min_cnt값과, tmp + 숫자로 눌리는 len을 더해서 최솟값을 갱신한다.
            }
        }

        System.out.println(min_cnt);
    }

    private static int check(int i) {
        if (i == 0) {
            if (arr[i]) {
                return 0;
            } else
                return 1;
        }
        int len = 0;
        while (i > 0) {
            if (arr[i % 10]) {
                return 0;
            }
            i /= 10;
            len++;
        }
        return len;
    }
}
