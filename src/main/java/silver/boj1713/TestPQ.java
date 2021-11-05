package silver.boj1713;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPQ {
    static class Test {
        int val;
        int num;

        public Test(int val, int num) {
            this.val = val;
            this.num = num;
        }
    }
    public static void main(String[] args) {

        PriorityQueue<Test> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.num));

        pq.offer(new Test(0, 0));
        pq.offer(new Test(1, 0));
        pq.offer(new Test(2, 1));
        pq.offer(new Test(3, 0));


        while (!pq.isEmpty()) {

            Test peek = pq.peek();
            if (peek.val == 1) {

            }

            Test poll = pq.poll();
            System.out.println(poll.val);
        }
    }
}
