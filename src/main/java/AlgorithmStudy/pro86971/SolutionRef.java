package AlgorithmStudy.pro86971;

import java.util.ArrayList;
import java.util.List;

public class SolutionRef {
    static class Remove {
        int start;
        int target;

        public Remove(int start, int target) {
            this.start = start;
            this.target = target;
        }
    }

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int count;
    public int solution(int n, int[][] wires) {

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int n1 = wire[0];
            int n2 = wire[1];
            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> arrayList = arr.get(i);
            List<Remove> list = new ArrayList<>();

            for (Integer integer : arrayList) {
                list.add(new Remove(i, integer));
            }
            boolean[] chk;

            for (Remove remove : list) {
                // 양방향 지우기
                int s = remove.start;
                int t = remove.target;
                arr.get(s).remove(Integer.valueOf(t));
                arr.get(t).remove(Integer.valueOf(s));

                chk = new boolean[n + 1];
                chk[i] = true;
                count = 1;
                dfs(chk, i);
                int notCount = n - count;
                answer = Math.min(answer, Math.abs(count - notCount));

                // 양방향 다시 연결
                arr.get(s).add(t);
                arr.get(t).add(s);
            }

        }
        return answer;
    }

    private void dfs(boolean[] chk, int start) {
        ArrayList<Integer> list = arr.get(start);
        for (Integer i : list) {
            if (!chk[i]) {
                chk[i] = true;
                count++;
                dfs(chk, i);
            }
        }
    }
}

