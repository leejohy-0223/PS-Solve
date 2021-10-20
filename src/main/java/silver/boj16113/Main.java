package silver.boj16113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;
    static int l;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[5][n / 5];

        char[] chars = br.readLine().toCharArray();
        l = n / 5;
        int idx = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < l; j++) {
                board[i][j] = chars[idx];
                idx++;
            }
        }

        int left = 0;
        for (int i = left; i < l; ) {
            if (board[0][i] == '#') {
                StringBuilder tmp;
                tmp = new StringBuilder();

                if (i + 2 >= l) {
                    sb.append(1);
                    break;
                }

                for (int k = i; k < i + 3; k++) {
                    tmp.append(board[0][k]);
                }

                // 1, 4 제외 처리
                if (tmp.toString().equals("###")) {
                    checkNumber(i);
                } else { // 1, 4는 개수 세어 처리
                    board[0][i] = '.';
                    count = 1;
                    dfs(0, i);

                    if (count == 5) {
                        sb.append(1);
                        i += 2;
                        continue;
                    } else
                        sb.append(4);
                }

                i += 4;
                continue;
            }
            i += 1;
        }
        System.out.println(sb);

    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= l || board[nx][ny] == '.') continue;
            board[nx][ny] = '.';
            count++;
            dfs(nx, ny);
        }
    }

    private static void checkNumber(int idx) {

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = idx; j < idx + 3; j++) {
                tmp.append(board[i][j]);
            }
        }

        String [] num = new String[10];

        //1과 4는 필요없다.
        num[0] = "####.##.##.####";
        num[2] = "###..#####..###";
        num[3] = "###..####..####";
        num[5] = "####..###..####";
        num[6] = "####..####.####";
        num[7] = "###..#..#..#..#";
        num[8] = "####.#####.####";
        num[9] = "####.####..####";

        for(int i = 0; i<num.length; i++){
            if(tmp.toString().equals(num[i])){
                sb.append(i);
                break;
            }
        }
    }
}
