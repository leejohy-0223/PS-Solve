package silver.boj1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger[] mem = new BigInteger[31];
    static int n = 0;
    static int m = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sb.append(combination(m, n) + "\n");
        }
        System.out.println(sb);
    }

    private static BigInteger combination(int m, int n) {
        return factorial(m).divide(factorial(n).multiply(factorial(m - n)));
    }

    private static BigInteger factorial(int i) {
        if(i == 0 || i == 1) {
            return mem[i] = BigInteger.ONE;
        }
        if(mem[i] != null) {
            return mem[i];
        }
        return mem[i] = factorial(i - 1).multiply(BigInteger.valueOf(i));
    }


//    private static void DFS(int first, int depth) {
//        if(depth == n + 1) {
//            result ++;
//            return;
//        }
//
//        for(int i=first; i<=m; i++) {
//            DFS(i + 1, depth + 1);
//        }
//    }
}
