package AlgorithmStudy.pro43165;

public class SolutionRef {
    int cnt;
    public int solution(int[] numbers, int target) {

        dfs(0, 0, target, numbers);

        return cnt;
    }

    private void dfs(int sum, int i, int target, int[] numbers) {
        if (i == numbers.length) {
            if (sum == target) {
                cnt ++;
            }
            return;
        }
        dfs(sum + numbers[i], i + 1, target, numbers);
        dfs(sum - numbers[i], i + 1, target, numbers);

    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        System.out.println(s.solution(new int[] {1, 1, 1, 1, 1}, 3));
    }
}
