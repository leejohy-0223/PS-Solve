package programmers.kakao.p2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
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
        Integer operationCount1 = checkQueue(queue1, queue2, sum1, targetValue);
        Integer operationCount2 = checkQueue(queue2, queue1, sum2, targetValue);

        if (operationCount1 == -1 && operationCount2 == -1) {
            return -1;
        }

        if (operationCount1 == -1) {
            return operationCount2;
        }

        if (operationCount2 == -1) {
            return operationCount1;
        }

        return Math.min(operationCount1, operationCount2);
    }

    private Integer checkQueue(int[] queue1, int[] queue2, long sum, long targetValue) {
        long tmpSum;
        List<Integer> copyOfQueue;
        int operationCount;
        for (int i = 0; i < queue1.length; i++) {
            // queue1에서 queue2로 i까지만 우선 보낸다.
            tmpSum = sum;
            operationCount = 0;
            copyOfQueue = Arrays.stream(queue2)
                .boxed()
                .collect(Collectors.toList());
            for (int j = 0; j <= i; j++) {
                tmpSum -= queue1[j];
                copyOfQueue.add(queue1[j]);
                operationCount++;
            }

            // 다시 copyOfQueue2로부터 하나씩 더해가면서 반절인지 확인한다.
            for (Integer cur : copyOfQueue) {
                if (tmpSum == targetValue) {
                    return operationCount;
                }
                if (tmpSum > targetValue) {
                    break;
                }
                tmpSum += cur;
                operationCount++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int solution = s.solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1});
        int solution = s.solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2});
        System.out.println(solution);
    }
}
