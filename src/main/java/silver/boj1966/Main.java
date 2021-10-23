package silver.boj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Order{
    int idx;
    int value;

    public Order(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Order> queue = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                queue.offer(new Order(i, tmp));
            }

            int answer = 0;
            while(!queue.isEmpty()) {
                Order tmp = queue.poll();
                for(Order x : queue) {
                    if(tmp.value < x.value) {
                        queue.offer(tmp);
                        tmp = null;
                        break;
                    }
                }
                if(tmp != null) {
                    answer++;
                    if(tmp.idx == M) {
                        break;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}