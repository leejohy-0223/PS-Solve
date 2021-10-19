package silver.boj2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int L = Integer.parseInt(strings[1]);
        int[] roads = new int[L + 1];
        int[] red = new int[L + 1];
        int[] green = new int[L + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int D = Integer.parseInt(stringTokenizer.nextToken());
            int R = Integer.parseInt(stringTokenizer.nextToken());
            int G = Integer.parseInt(stringTokenizer.nextToken());
            roads[D] = 1;
            red[D] = R;
            green[D] = G;
        }
        int seconds = 0;
        for (int i = 0; i < roads.length; i++) {
            seconds++;

            // 신호등이 있을 경우 시간 추가
            if (roads[i] != 0) {
                if(seconds % (red[i] + green[i]) <= red[i]) {
                    seconds += (red[i] - seconds % (red[i] + green[i]));
                }
            }
        }
        System.out.println(seconds);
    }
}
