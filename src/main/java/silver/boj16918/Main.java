package silver.boj16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bomb {
    int x;
    int y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static Queue<Bomb> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = chars[j];
                if (arr[i][j] == 'O') {
                    queue.offer(new Bomb(i, j));
                }
            }
        }

        int time = 1;
        while (true) {

            // 짝수의 시간에 폭탄을 설치한다.
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (arr[i][j] == '.') {
                            arr[i][j] = 'O';
                        }
                    }
                }
            } else if (time > 1) { // 홀수의 시간에는 폭발을 시킨다.

                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Bomb poll = queue.poll();
                    // 이전에 처리되었을 경우 continue를 날린다.

                    // 자신 포함 주변을 1로 변경한다.
                    arr[poll.x][poll.y] = '.';
                    for (int i = 0; i < 4; i++) {
                        int nx = dx[i] + poll.x;
                        int ny = dy[i] + poll.y;

                        if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                            arr[nx][ny] = '.';
                        }
                    }
                }

                // 이 시점에서 폭탄 위치를 다시 큐에 넣는다.
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (arr[i][j] == 'O') {
                            queue.offer(new Bomb(i, j));
                        }
                    }
                }
            }
            if (time == N) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                return;
            }
            time++;
        }


    }
}
