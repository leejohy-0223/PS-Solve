package silver.boj1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] square = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                square[i][j] = chars[j] - '0';
            }
        }

        int result = 1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int ref = square[i][j];
                for (int k = j + 1; k < m; k++) {
                    int another = square[i][k];
                    if (another == ref) {
                        int l = k - j;
                        // 아래 확인, 대각선 확인
                        if (i + l < n && square[i + l][j] == ref && square[i + l][k] == ref) {
                            result = Math.max(result, (l+1) * (l+1));
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
