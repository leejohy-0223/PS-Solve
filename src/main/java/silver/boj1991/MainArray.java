package silver.boj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainArray {

    static int[][] node;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new int[N][2];

        String inputNode;
        int cursor;

        while (N-- > 0) {
            inputNode = br.readLine();
            cursor = inputNode.charAt(0) - 65;
            node[cursor][0] = inputNode.charAt(2) - 65;
            node[cursor][1] = inputNode.charAt(4) - 65;
        }

        sb = new StringBuilder();
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);

        System.out.println(sb);
    }

    private static void preOrder(int n) {
        if (n < 0) return;
        sb.append((char) (n + 65));
        preOrder(node[n][0]);
        preOrder(node[n][1]);
    }

    private static void inOrder(int n) {
        if (n < 0) return;
        inOrder(node[n][0]);
        sb.append((char) (n + 65));
        inOrder(node[n][1]);
    }

    private static void postOrder(int n) {
        if (n < 0) return;
        postOrder(node[n][0]);
        postOrder(node[n][1]);
        sb.append((char) (n + 65));
    }
}
