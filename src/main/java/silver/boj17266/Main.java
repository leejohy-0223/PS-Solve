package silver.boj17266;

import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] lamp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        lamp = new int[m];

        for (int i = 0; i < m; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }

        int minL = 1;
        int maxL = n;
        while (minL < maxL) {
            int mid = (minL + maxL) / 2;
            if (possibleHeight(mid)) {
                maxL = mid;
            } else {
                minL = mid + 1;
            }
        }
        System.out.println(minL);
    }

    private static boolean possibleHeight(int mid) {
        int postEnd = 0;
        int curStart;
        int curEnd = 0;
        for (int l : lamp) {
            curStart = l - mid;
            curEnd = l + mid;
            if (curStart > postEnd) {
                return false;
            }
            postEnd = curEnd;
        }
        return curEnd >= n;
    }
}
