package silver.boj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = Integer.MAX_VALUE;
    static boolean[][] tb1;
    static boolean[][] tb2;
    static boolean[][] inputBoard;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        tb1 = getTemplateBoard(true, 8, 8);
        tb2 = getTemplateBoard(false, 8, 8);

        inputBoard = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String str = br.readLine();
            for (int j = 0; j < width; j++) {
                if (str.charAt(j) == 'W') {
                    inputBoard[i][j] = true; // white일때는 true
                } else
                    inputBoard[i][j] = false; // black은 false
            }
        }

        for (int i = 0; i <= height - 8; i++) {
            for (int j = 0; j <= width - 8; j++) {
                result = Math.min(result, countDraw(i, j));
            }
        }
        System.out.println(result);
    }

    private static int countDraw(int h, int w) {
        int result1 = 0;
        int result2 = 0;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(inputBoard[i+h][j+w] != tb1[i][j]) {
                    result1++;
                }
                if(inputBoard[i+h][j+w] != tb2[i][j]) {
                    result2++;
                }
            }
        }
        return Math.min(result1, result2);
    }


    private static boolean[][] getTemplateBoard(boolean b, int h, int w) {
        boolean[][] templateBoard = new boolean[h][w];
        boolean chk = b;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                templateBoard[i][j] = chk;
                chk = !chk;
            }
            if (w % 2 == 0) {
                chk = !chk;
            }
        }
        return templateBoard;
    }
}
