package silver.boj17266;

//어두운 굴다리
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] lamp = new int[m];

        for (int i = 0; i < m; i++)
            lamp[i] = Integer.parseInt(st.nextToken());

        binary_search(lamp, n);
    }

    private static void binary_search(int[] lamp, int n) {
        int left = 0;
        int right = n;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;

            if(isLightCovered(lamp,mid,n)) {
                right = mid; //덮는 경우
            }else { //못 덮는 경우
                left = mid+1;
            }
        }

        System.out.println(left);
    }

    private static boolean isLightCovered(int[] lamp, int height, int n) {
        int start =0;
        for (int i = 0; i < lamp.length; i++) {
            int left = lamp[i] - height;
            int right = lamp[i] + height;

            if(start < left)
                return false;
            else
                start = right;
        }

        if(n - start > 0)
            return false;
        return true;
    }
}
