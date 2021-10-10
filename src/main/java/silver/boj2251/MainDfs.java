package silver.boj2251;

import java.io.*;
import java.util.StringTokenizer;

public class MainDfs {
    static int A1, B1, C1;
    static boolean[][] chkAB = new boolean[252][252];
    static boolean[] chkC = new boolean[252];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A1 = Integer.parseInt(st.nextToken());
        B1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        DFS(0, 0, C1);
        for (int i = 0; i <= C1; i++) {
            if (chkC[i])
                bw.append(Integer.toString(i) + " ");
        }
        bw.close();
    }

    private static void DFS(int a, int b, int c) {
        if (chkAB[a][b]) {
            return;
        }

        if (a == 0) {
            chkC[c] = true;
        }

        chkAB[a][b] = true;

        // A -> B
        if (a + b > B1) {
            DFS(a - (B1 - b), B1, c);
        } else {
            DFS(0, a + b, c);
        }

        // B -> A
        if (b + a > A1) {
            DFS(A1, b - (A1 - a), c);
        } else {
            DFS(a + b, 0, c);
        }

        // C -> A
        if (a + c > A1) {
            DFS(A1, b, c - (A1 - a));
        } else {
            DFS(a + c, b, 0);
        }

        // C -> B
        if (b + c > B1) {
            DFS(a, B1, c - (B1 - b));
        } else {
            DFS(a, b + c, 0);
        }

        // A -> C && B -> C
        DFS(0, b, a + c);
        DFS(a, 0, b + c);
    }
}
