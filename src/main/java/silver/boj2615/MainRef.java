package silver.boj2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    static int[] dx = { 0, 1, 1, -1 };
    static int[] dy = { 1, 0, 1, 1 };
    static int[][] map;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[20][20];
        for (int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (map[i][j] != 0)
                    for (int d = 0; d < 4; d++) {
                        cnt = 0;
                        dfs(i, j, d);

                        // dfs의 결과(한방향 dfs)로 cnt가 5가 나왔다는건, 그 방향의 뒤만 보면 된다.
                        // 얘를 들어 방향이 ->(0, +1)이었다고 가정하면, ->방향으로 방향이 5개 계산되었으며, <- 방향으로 봤을 때 같지 않은 것만 보면 된다.
                        // 즉, ->방향으로는 5개만 세어졌으므로 맨 끝에서 추가로 하나 더 있는 것은 볼 필요 없다.(모두 센것)
                        if (cnt == 5 && map[i - dx[d]][j - dy[d]] != map[i][j]) {
                            System.out.println(map[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
            }
        }
        System.out.println("0");

    }

    public static void dfs(int x, int y, int d) {
        int nx = dx[d] + x;
        int ny = dy[d] + y;
        cnt++;
        if (isPossible(nx, ny) && map[x][y] == map[nx][ny]) {
            dfs(nx, ny, d);
        }
    }

    public static boolean isPossible(int x, int y) {
        if (x <= 0 || x >= 20 || y <= 0 || y >= 20)
            return false;

        return true;
    }
}
