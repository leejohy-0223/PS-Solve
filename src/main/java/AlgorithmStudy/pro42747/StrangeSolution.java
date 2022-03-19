package AlgorithmStudy.pro42747;

public class StrangeSolution {
    public int solution(int[] citations) {
        int answer = 0;
        int L = citations.length;
        while (L-- > 0) {
            int cnt = 0;
            for (int c : citations) {
                if (c >= L) {
                    cnt++;
                }
            }
            if (L <= cnt) {
                answer = L;
                break;
            }
        }
        return answer;
    }
}
