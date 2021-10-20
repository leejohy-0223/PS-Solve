package test;

public class Solution2 {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public boolean[][] visited;
    public boolean[][] colorVisited;
    public boolean finalCheck;
    static int[][] board = new int[6][6];

    public String[] solution(int[][] macaron) {
        String[] answer = {};

        for (int[] get : macaron) {

            int position = get[0] - 1;
            int color = get[1];

            // 들어오는 마카롱 초기 세팅하기
            for (int j = 5; j >= 0; j--) {
                if (board[j][position] == 0) {
                    board[j][position] = color;
                    break;
                }
            }

            // 현재 배열된 마카롱을 기준으로, 마카롱이 있는 노드에 대해서 dfs 진행하기
            while (true) {
                finalCheck = false;
                deepDFS();

                if (!finalCheck) {
                    break;
                }
            }
        }

        return answer;
    }

    private void deepDFS() {
        // dfs 실행해서 3개 이상의 블록 없애기
        executeDFS();
        // 남은 공간 제거하고 보드 다시 세팅하기
        boardSet();
    }

    private void boardSet() {
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 5; j >= 0; j--) {
                if (board[j][i] != 0) {
                    sb.append(board[j][i]);
                }
            }
            int idx = 0;
            for (int j = 5; j >= (6 - sb.length()); j--) {
                String s = sb.toString();
                board[j][i] = Integer.parseInt(s.charAt(idx) + "");
                idx++;
            }
            for (int j = 6 - sb.length() - 1; j >= 0; j--) {
                board[j][i] = 0;
            }
        }
    }

    private void executeDFS() {
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < 6; k++) {
                if (board[j][k] != 0) {
                    visited = new boolean[6][6];
                    visited[j][k] = true;
                    DFS(j, k, 1, board[j][k]);
                }
            }
        }
    }

    private void DFS(int j, int k, int count, int color) {

        // count가 3개 이상이면, 모두 0으로 바꾸는 과정 수행
        if (count >= 3) {
            finalCheck = true; // 0으로 바꾸는 동작이 실행된다면 finalCheck를 true로 두어, 다음번에도 탐색할 여지를 만들기
            colorVisited = new boolean[6][6];
            zeroDFS(j, k, color);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + j;
            int ny = dy[i] + k;

            if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || visited[nx][ny] || board[nx][ny] != color || board[nx][ny] == 0)
                continue;
            visited[nx][ny] = true;
            DFS(nx, ny, count + 1, color);
        }

    }

    private void zeroDFS(int j, int k, int color) {
        board[j][k] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + j;
            int ny = dy[i] + k;

            if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || colorVisited[nx][ny] || board[nx][ny] != color || board[nx][ny] == 0)
                continue;
            colorVisited[nx][ny] = true;
            board[nx][ny] = 0;
            zeroDFS(nx, ny, color);
        }
    }

    public static void main(String[] args) {
//        int[][] test = {{1, 1}, {1, 2}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {3, 4}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 4}, {4, 3}, {5, 4}, {6, 1}};

        int[][] test = {{1, 6}, {2, 7}, {2, 3}, {2, 2}, {2, 1}, {3, 1}, {3, 2}, {3, 2}, {3, 3}, {4, 5}, {4, 3}, {4, 3}};
        Solution2 s = new Solution2();
        s.solution(test);
        String[] result = {"000000", "000000", "000000", "000000", "000000", "404001"};
    }
}
