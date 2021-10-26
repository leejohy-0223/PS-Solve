package silver.boj9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder[] sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int size = (int) (Math.pow(2, N) - 1);
        arr = new int[size+1];
        sb = new StringBuilder[size];

        for (int i = 0; i < size; i++) {
            sb[i] = new StringBuilder();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int mid = size / 2;
        sb[0].append(arr[mid]);
        findMid(0, mid - 1, 1);
        findMid(mid + 1, size - 1, 1);

        for (StringBuilder s : sb) {
            System.out.println(s);
        }

    }

    private static void findMid(int left, int right, int depth) {
        if (left == right) {
            sb[depth].append(arr[left]).append(" ");
            return;
        }

        int mid = (left + right) / 2;
        sb[depth].append(arr[mid]).append(" ");
        findMid(left, mid - 1, depth + 1);
        findMid(mid + 1, right, depth + 1);
    }
}
