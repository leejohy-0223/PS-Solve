package programmers.kakao.p2;

public class SolutionRef {

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        for (int i : queue1) {
            sum1 += i;
        }
        for (int i : queue2) {
            sum2 += i;
        }
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        long targetValue = (sum1 + sum2) / 2;

        int left = 0;
        int right = queue1.length - 1;
        int destLength = queue1.length + queue2.length;
        int[] dest = new int[destLength];
        System.arraycopy(queue1, 0, dest, 0, queue1.length);
        System.arraycopy(queue2, 0, dest, queue1.length, queue2.length);

        int count = 0;
        while (sum1 != targetValue) {
            if (left == right || right == destLength - 1) {
                return -1;
            }
            if (sum1 < targetValue) {
                right++;
                sum1 += dest[right];
            } else {
                sum1 -= dest[left];
                left++;
            }
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        int solution = s.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1});
        // int solution = s.solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2});
        // int solution = s.solution(new int[] {1, 2, 1, 2}, new int[] {2, 9, 1, 10});
        System.out.println(solution);
    }

}
