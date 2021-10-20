package silver.boj8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        while (N-- > 0) {

            int x = 0, y = 0;
            int minX = 0, minY = 0;
            int maxX = 0, maxY = 0;
            int direction = 0;

            char[] chars = br.readLine().toCharArray();
            for (char aChar : chars) {

                if (aChar == 'L') {
                    if (--direction < 0) {
                        direction = 3;
                    }
                    continue;
                }

                if (aChar == 'R') {
                    if (++direction > 3) {
                        direction = 0;
                    }
                    continue;
                }

                if (aChar == 'F') {
                    x += dx[direction];
                    y += dy[direction];
                } else {
                    x -= dx[direction];
                    y -= dy[direction];
                }

                // 최대 갱신
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);

                // 최소 갱신
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);

            }

            int result = (maxX - minX) * (maxY - minY);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
