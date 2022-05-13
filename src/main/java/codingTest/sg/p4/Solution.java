package codingTest.sg.p4;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] board;
    static int count;

    public String[] solution(int[][] macaron) {
        board = new int[6][6];

        for (int[] ints : macaron) {
            int color = ints[1];
            int pos = ints[0] - 1;

            for (int i = 5; i >= 0; i--) {
                if (board[i][pos] == 0) {
                    board[i][pos] = color;
                    break;
                }
            }
            // 떨어뜨릴 때마다 체크
            boolean replay = true;

            while (replay) {
                boolean change = false;
                visited = new boolean[6][6];
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            count = 1;
                            countMacaron(i, j);
                        }
                        if (count >= 3) {
                            change = true;
                            removeMacaron(i, j, board[i][j]);
                        }
                    }
                }
                if(change) {
                    reArrangeBoard();
                    continue;
                }
                replay = false;
            }
        }

        String[] result = new String[6];
        int idx = 0;
        for (int[] ints : board) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt);
            }
            result[idx++] = sb.toString();
        }
        return result;
    }

    private void reArrangeBoard() {
        List<Integer> list;
        for (int i = 0; i < 6; i++) {
            list = new ArrayList<>();
            for (int j = 5; j >= 0; j--) {
                if (board[j][i] != 0) {
                    list.add(board[j][i]);
                }
            }
            int index = 5;
            for (Integer value : list) {
                board[index][i] = value;
                index--;
            }
            for (int j = index; j >= 0 ; j--) {
                board[j][i] = 0;
            }
        }
    }

    private void removeMacaron(int i, int j, int color) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || board[nx][ny] == 0) {
                continue;
            }

            if ((color == board[nx][ny])) {
                board[nx][ny] = 0;
                removeMacaron(nx, ny, color);
            }
        }
    }

    private void countMacaron(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || visited[nx][ny] || board[nx][ny] == 0) {
                continue;
            }

            if ((board[i][j] == board[nx][ny])) {
                visited[nx][ny] = true;
                count++;
                countMacaron(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // s.solution(new int[][] {{1, 1}, {2, 1}, {1, 2}, {3, 3}, {6, 4}, {3, 1}, {3, 3}, {3, 3}, {3, 4}, {2, 1}});
        // s.solution(new int[][] {{1, 1}, {2, 1}, {3, 1}, {4, 1}});
        // String[] solution = s.solution(
        //     new int[][] {{1, 1}, {1, 2}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {3, 4}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 4},
        //         {4, 3}, {5, 4}, {6, 1}});
        String[] solution = s.solution(
            new int[][] {{1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 1}, {3, 1}, {3, 1}});

        for (String s1 : solution) {
            System.out.println(s1);
        }
    }
}
