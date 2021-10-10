package gold.boj1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int[][] map;
    int zeroX;
    int zeroY;

    public Position(int[][] map, int zeroX, int zeroY) {
        this.map = map;
        this.zeroX = zeroX;
        this.zeroY = zeroY;
    }
}

public class Main {

    static int[][] ref = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x, y;
    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] inputT = new int[3][3];
        StringTokenizer st;
        x = 0;
        y = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                inputT[i][j] = Integer.parseInt(st.nextToken());
                if (inputT[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(inputT, x, y));
        String s = getStringBuilder(inputT).toString();
        map.put(s, true);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position pos = queue.poll();
                if (comp(pos.map)) {
                    System.out.println(depth);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = pos.zeroX + dx[j];
                    int ny = pos.zeroY + dy[j];
                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int[][] copy = makeCopyArrayAndChange(pos, nx, ny);
                        if(validCopy(copy)) {
                            queue.offer(new Position(copy, nx, ny));
                        }
                    }
                }
            }
            depth++;
        }
        System.out.println(-1);
    }

    private static boolean validCopy(int[][] copy) {
        StringBuilder sb = getStringBuilder(copy);
        if(!map.containsKey(sb.toString())) {
            map.put(sb.toString(), true);
            return true;
        }
        return false;
    }

    private static StringBuilder getStringBuilder(int[][] copy) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(copy[i][j]);
            }
        }
        return sb;
    }

    private static int[][] makeCopyArrayAndChange(Position pos, int nx, int ny) {
        int[][] copy = new int[3][3];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                copy[k][l] = pos.map[k][l];
            }
        }
        int tmp = copy[nx][ny];
        copy[nx][ny] = copy[pos.zeroX][pos.zeroY];
        copy[pos.zeroX][pos.zeroY] = tmp;
        return copy;
    }

    private static boolean comp(int[][] pos) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pos[i][j] != ref[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
