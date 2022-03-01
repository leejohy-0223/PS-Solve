package AlgorithmStudy.pro43165;

public class Solution {

    static int N;
    static char[] op = new char[] {'+', '-'};
    static char[] opList;
    static int count = 0;

    public int solution(int[] numbers, int target) {
        N = numbers.length;
        opList = new char[N];
        permu(0, numbers, target, 0);
        return count;
    }

    private static void permu(int L, int[] array, int target, int result) {
        if (L == N) {
            for (int i = 0; i < opList.length; i++) {
                if (opList[i] == '+') {
                    result += array[i];
                } else
                    result -= array[i];
            }
            if (result == target) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            opList[L] = op[i];
            permu(L + 1, array, target, result);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int solution = s.solution(new int[] {1, 1, 1, 1, 1}, 3);
        int solution2 = s.solution(new int[] {4, 1, 2, 1}, 4);
        // System.out.println(solution);
        System.out.println("solution2 = " + solution2);
    }
}
