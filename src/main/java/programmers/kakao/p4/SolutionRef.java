package programmers.kakao.p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionRef {

    static final int MIN = -1;

    static List<List<QueueNode>> graph = new ArrayList<>();
    static int[] d;
    static boolean[] chk;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2]; // summit, intensity

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화
        for (int[] path : paths) {
            int n1 = path[0];
            int n2 = path[1];
            graph.get(n1).add(new QueueNode(n2, path[2]));
            graph.get(n2).add(new QueueNode(n1, path[2]));
        }

        for (int gate : gates) {
            d = new int[n + 1];
            Arrays.fill(d, MIN);
            chk = new boolean[n + 1];
            for (int summit : summits) {
                System.out.println("gate : " + gate + ", " + "summit : " + summit);
                solve(gate, summit, gates, summits);
                System.out.println();
            }
        }

        return null;
    }

    private void solve(int start, int summit, int[] gates, int[] summits) {
        Queue<CompareNode> queue = new LinkedList<>();
        queue.offer(new CompareNode(0, start));
        d[start] = 0;
        chk[start] = true;

        while (!queue.isEmpty()) {
            CompareNode node = queue.poll();

            for (int i = 0; i < graph.get(node.nextNode).size(); i++) {
                // 연결된 노드 빼오기
                QueueNode tmp = graph.get(node.nextNode).get(i);
                int index = tmp.getIndex();
                chk[index] = true;

                // 간격 거리
                int beforeValue = node.beforeValue;
                int distance = tmp.getDistance();
                d[index] = Math.max(beforeValue, distance);
                queue.add(new CompareNode(d[index], index));
            }

        }
        for (int i : d) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static class QueueNode {
        private int index;
        private int distance;

        public QueueNode(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }

    static class CompareNode {
        private int beforeValue;
        private int nextNode;

        public CompareNode(int beforeValue, int nextNode) {
            this.beforeValue = beforeValue;
            this.nextNode = nextNode;
        }
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        // int[] solution = s.solution(7,
        //     new int[][] {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[] {1},
        //     new int[] {2, 3, 4});

        int[] solution = s.solution(7,
            new int[][] {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[] {3, 7},
            new int[] {1, 5});

        // int[] solution = s.solution(7,
        //     new int[][] {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[] {3, 7},
        //     new int[] {1, 5});

        // for (int i : solution) {
        //     System.out.println(i);
        // }
    }

}
