package codingTest.eleSt.Task2;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int initValue = 1;
        int result = 0;
        for (int num : A) {
            if (num != initValue) {
                pq.add(num);
                continue;
            }
            result++;
            initValue++;
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int poll = pq.poll();
                if (poll == initValue) {
                    initValue++;
                    continue;
                }
                pq.add(poll);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int solution = s.solution(new int[] {2, 1, 3, 5, 4});
        // int solution = s.solution(new int[] {2, 3, 4, 1, 5});
        int solution = s.solution(new int[] {1, 3, 4, 2, 5});
        System.out.println("solution = " + solution);
    }

}
