package barkingDog.BFS0x09.boj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MainRef {

    static int N, M, px, py;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pos> queue;

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == '@') {
                        px = i;
                        py = j;
                        continue;
                    }
                    if (map[i][j] == '*') {
                        queue.add(new Pos(i, j));
                    }
                }
            }
            // 사람은 이후에 큐에 넣는다. 불 먼저 퍼뜨리고, 사람의 위치를 정할 것이다.
            queue.add(new Pos(px, py));
            int result = bfs();
            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                Pos cur = queue.poll();
                char now = map[cur.x][cur.y];
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        if(now == '@') {
                            return result;
                        }
                        continue;
                    }
                    if (map[nx][ny] != '.') {
                        continue;
                    }
                    // @ (사람)도 자신의 길을 안지워도 된다. 어차피 다시 돌아오지 않을 뿐더러 여기에 이후에 불이 온다 가정해도 전혀 상관 없다.
                    map[nx][ny] = now;
                    queue.add(new Pos(nx, ny));
                }
            }
        }
        return -1;
    }
}
