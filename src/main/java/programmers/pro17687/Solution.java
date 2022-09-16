package programmers.pro17687;

public class Solution {
    /**
     *
     * @param n 진수로
     * @param t 개를 구하고
     * @param m 명 중
     * @param p 번째
     * @return
     */
    public String solution(int n, int t, int m, int p) {
        String template = numToString(n, t, m);
        StringBuilder sb = new StringBuilder();

        while (sb.length() != t) {
            sb.append(template.charAt(p - 1));
            p += m;
        }
        return sb.toString();
    }

    public String numToString(int n, int t, int m) {
        StringBuilder sb = new StringBuilder();
        int number = 0;

        while (sb.length() <= t * m) {
            sb.append(Integer.toString(number++, n));
        }

        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2진수, 4개를 구하고, 2명중 1번째
        System.out.println(s.solution(2, 4, 2, 1));
    }


}
