package codingTest.eleSt.Task1;

public class Solution {
    public int solution(int A, int B) {
        String SA = String.valueOf(A);
        String SB = String.valueOf(B);

        if (!SB.contains(SA)) {
            return -1;
        }

        return SB.indexOf(SA);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int solution = s.solution(0, 195036);
        int solution = s.solution(88, 999988998);
        System.out.println(solution);
    }


}
