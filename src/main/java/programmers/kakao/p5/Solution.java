package programmers.kakao.p5;

public class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[][] solution(int[][] rc, String[] operations) {
        int count = 1;
        String batch = operations[0];

        for (int i = 1; i < operations.length; i++) {
            String operation = operations[i];
            if (operation.equals(batch)) {
                count++;
            } else {
                // batch 처리 후 continue
                if (batch.equals("ShiftRow")) {
                    shiftRow(rc, count);
                } else {
                    rotate(rc, count);
                }
                count = 1;
                batch = operation;
                if (i == operations.length - 1) {
                    if (operation.equals("ShiftRow")) {
                        shiftRow(rc, count);
                    } else {
                        rotate(rc, count);
                    }
                }
            }
        }
        return rc;
    }

    private void shiftRow(int[][] rc, int count) {
        System.out.println("count in shiftRow = " + count);
        int[] lastRow = rc[rc.length - 1].clone();
        for (int i = rc.length - 2; i >= 0 ; i--) {
            rc[i + 1] = rc[i].clone();
        }
        rc[0] = lastRow;
    }

    private void rotate(int[][] rc, int count) {
        System.out.println("count in rotate = " + count);
        int direction = 0;
        int value = rc[0][0];
        int x = 0, y = 0;
        while (direction < 4) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < rc.length && ny >= 0 && ny < rc[0].length) {
                rc[x][y] = rc[nx][ny];
                x = nx;
                y = ny;
            } else {
                direction++;
            }
        }
        rc[0][1] = value;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new String[]{"Rotate", "Rotate", "ShiftRow", "ShiftRow"});
        // s.solution(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}, null);
    }
}
