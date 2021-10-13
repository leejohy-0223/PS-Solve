package silver.boj2667;

import java.io.*;
import java.util.*;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    list.add(BFS(i, j));
                }
            }
        }
        Collections.sort(list);
        bw.write(list.size()+"\n");
        for (Integer value : list) {
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int BFS(int i, int j) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        int count = 1;
        arr[i][j] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Position poll = queue.poll();
            for (int k = 0; k < size; k++) {
                for (int l = 0; l < 4; l++) {
                    int nx = poll.x + dx[l];
                    int ny = poll.y + dy[l];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && (arr[nx][ny] == 1)) {
                        count++;
                        arr[nx][ny] = 0;
                        queue.offer(new Position(nx, ny));
                    }
                }
            }
        }
        return count;
    }
}
