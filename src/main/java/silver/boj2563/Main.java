package silver.boj2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] paper = new boolean[101][101]; // true : black / false : white
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int count = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int i = w; i < w + 10; i++) {
                for (int j = h; j < h + 10; j++) {
                    if (!paper[i][j]) {
                        paper[i][j] = true;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);


    }
}
