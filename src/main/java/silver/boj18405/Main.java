package silver.boj18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Germ {

    int value;
    int priority;
    int x, y;

    public Germ(int value, int priority, int x, int y) {
        this.value = value;
        this.priority = priority;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Germ> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N x N 사이즈의 시험관
        int K = Integer.parseInt(st.nextToken()); // K이하의 세균 value

        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.priority == o2.priority) {
                return o1.value - o2.value;
            }
            return o1.priority - o2.priority;
        });
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    queue.add(new Germ(arr[i][j], 0, i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 시간 흐름
        int fx = Integer.parseInt(st.nextToken()); // 찾고자 하는 x 좌표
        int fy = Integer.parseInt(st.nextToken()); // 찾고자 하는 y 좌표

        for (int i = 0; i < S; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Germ cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0) {
                        arr[nx][ny] = cur.value;
                        queue.add(new Germ(cur.value, i + 1, nx, ny));
                    }
                }
            }
        }
        System.out.println(arr[fx - 1][fy - 1]);
    }
}
