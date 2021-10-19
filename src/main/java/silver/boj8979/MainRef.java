package silver.boj8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st0 = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st0.nextToken());
        int k = Integer.parseInt(st0.nextToken());
        int[][] map = new int[n][4];
        int cnt = 1;
        int r = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (map[i][0] == k) r = i;
        }

        // k의 메달 정보 추출
        int a = map[r][1];
        int b = map[r][2];
        int c = map[r][3];

        // sorting 없이 이 방식으로 cnt를 올려서 등수를 추출
        // 모든 경우에 대해서 k의 메달 정보와 비교하게 되면, 최종 cnt가 결국 등수를 가리키게 된다.
        for (int i = 0; i < n; i++) {
            if (i == r) continue;
            if (map[i][1] == a) {
                if (map[i][2] == b) {
                    if (map[i][3] > c) cnt++;
                } else if (map[i][2] > b) cnt++;
            } else if (map[i][1] > a) cnt++;
        }
        System.out.println(cnt);
    }
}
