package programmers.kakao.p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    static List<List<Node>> list;
    static List<Integer> gate;
    static List<Integer> summit;
    static boolean[] chk;
    static int minIntensity = Integer.MAX_VALUE;
    static int resultSummit = 0;
    static Set<CheckSet> checkSets;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        list = new ArrayList<>();

        gate = Arrays.stream(gates).boxed().collect(Collectors.toList());
        summit = Arrays.stream(summits).boxed().collect(Collectors.toList());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int n1 = path[0];
            int n2 = path[1];
            list.get(n1).add(new Node(n2, path[2]));
            list.get(n2).add(new Node(n1, path[2]));
        }

        for (int i = 0; i < gates.length; i++) {
            int curGate = gates[i];
            chk = new boolean[n + 1];
            checkSets = new HashSet<>();
            for (int j = 0; j < summits.length; j++) {
                int curSummit = summits[j];
                // gate에서 summit까지 가는 도중, 가장 큰 intensity 찾기
                chk[curGate] = true;
                DFS(curGate, curSummit, 0);
            }
        }
        answer[0] = resultSummit;
        answer[1] = minIntensity;
        return answer;
    }

    private void DFS(int curPos, int curSummit, int intensity) {
        if (curPos == curSummit) {
            if (minIntensity > intensity) {
                minIntensity = intensity;
                resultSummit = curSummit;
                return;
            }
            if (minIntensity == intensity) {
                resultSummit = Math.min(resultSummit, curSummit);
            }
            return;
        }

        List<Node> nodes = list.get(curPos);
        for (Node node : nodes) {
            // 이동하고자 하는 노드가 gate이거나, 이미 방문한 노드라면
            int targetNode = node.target;
            CheckSet checkSet = new CheckSet(curPos, targetNode);
            if (gate.contains(targetNode) || chk[targetNode] || checkSets.contains(checkSet)) {
                continue;
            }
            // 타겟 노드가 현재 가고자 하는 summit은 아니지만, summit에 포함된 타겟이면,
            if (targetNode != curSummit && summit.contains(targetNode)) {
                continue;
            }
            checkSets.add(checkSet);
            chk[targetNode] = true;
            DFS(targetNode, curSummit, Math.max(intensity, node.dist));
            chk[targetNode] = false;
        }
    }

    static class Node {
        int target;
        int dist;

        public Node(int target, int dist) {
            this.target = target;
            this.dist = dist;
        }
    }

    static class CheckSet {
        int n1;
        int n2;

        public CheckSet(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CheckSet checkSet = (CheckSet)o;
            return (n1 == checkSet.n1 && n2 == checkSet.n2) || (n1 == checkSet.n2 && n2 == checkSet.n1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(n1, n2) + Objects.hash(n2, n1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // int[] solution = s.solution(7,
        //     new int[][] {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[] {1},
        //     new int[] {2, 3, 4});

        // int[] solution = s.solution(7,
        //     new int[][] {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[] {3, 7},
        //     new int[] {1, 5});

        int[] solution = s.solution(7,
            new int[][] {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[] {3, 7},
            new int[] {1, 5});

        for (int i : solution) {
            System.out.println(i);
        }

        CheckSet checkSet = new CheckSet(1, 2);
        CheckSet checkSet1 = new CheckSet(2, 1);
        Set<CheckSet> sets = new HashSet<>();
        sets.add(checkSet);
        sets.add(checkSet1);

        System.out.println(sets.size());
    }
}
