package silver.boj16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        char[][] map1 = new char[r][c];
        char[][] map2 = new char[r][c];
        char[][] map3 = new char[r][c];
        char[][] map4 = new char[r][c];

        for (int i = 0; i < r; i++) {
            map1[i] = br.readLine().toCharArray(); // 이렇게 바로 넣을 수 있다.
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map2[i][j] = 'O'; // 모두 폭탄 설치(2, 4, 6 ... )
                map3[i][j] = 'O'; //
                map4[i][j] = 'O';
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map1[i][j] == 'O') { // 폭탄있는 경우, 자신 + 상하좌우를 모두 .으로 변경시킴
                    map3[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                            map3[nr][nc] = '.';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map3[i][j] == 'O') {
                    map4[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                            map4[nr][nc] = '.';
                        }
                    }
                }
            }
        }

        // 시간의 변화에 따라서 계속 맵이 반복되므로, 일치하는 맵을 출력해주면 된다.
        if (t == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map1[i][j]);
                }
                sb.append("\n");
            }
        } else {

            // 3 -> 7 -> 11 -> 15...
            // 5 -> 9 -> 13 -> 17...
            // 다음과 같이 4씩 증가하며 반복되므로, 4의 나머지로 하면 3 또는 5를 얻을 수 있다.
            t %= 4;
            if (t == 1) { // 나머지가 1일 경우, 5 -> 9 -> 13 패턴을 따른다.
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(map4[i][j]);
                    }
                    sb.append("\n");
                }
            } else if (t == 3) { // 나머지가 3일 경우, 3 -> 7 -> 11 패턴을 따른다.
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(map3[i][j]);
                    }
                    sb.append("\n");
                }
            } else {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        sb.append(map2[i][j]);
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
        System.out.println(9 % 4);
    }
}
