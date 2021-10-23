package silver.boj1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                board[i][j] = br.read()-'0';
            }
            br.readLine();
        }

        System.out.println(solution(board));

        br.close();
    }

    public static int solution(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        int length = Math.min(N, M);

        for(int i=length; i>0; i--) {
            for(int j=0; j+i-1<N; j++) {
                for(int k=0; k+i-1<M; k++) {
                    if(isSquare(board, j, k, i)) {
                        return i*i;
                    }
                }
            }
        }
        return 1;
    }

    public static boolean isSquare(int[][] board, int y, int x, int length) {
        if(board[y][x] != board[y+length-1][x]) return false;
        if(board[y][x] != board[y][x+length-1]) return false;
        return board[y][x] == board[y + length - 1][x + length - 1];
    }
}
