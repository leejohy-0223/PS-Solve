package silver.boj9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int left, right;

    public Point(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Point> queue = new LinkedList<>();
        int mid;
        Point now;

        int size = (int) (Math.pow(2, N) - 1);
        int[] list = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        queue.add(new Point(0, size - 1));
        while (!queue.isEmpty()) {

            int size1 = queue.size();

            for (int i = 0; i < size1; i++) {
                now = queue.poll();

                // 부모
                mid = (now.left + now.right) / 2;
                sb.append(list[mid]).append(" ");

                if (now.left != now.right) {
                    // 왼쪽 자식 큐에 넣기
                    queue.offer(new Point(now.left, mid - 1));

                    // 오른쪽 큐에 넣기
                    queue.offer(new Point(mid + 1, now.right));
                }
            }
            sb.append("\n"); // 큐 한번 끝날 때마다 개행 진행
        }
        System.out.println(sb);
    }
}
