package programmers.pro81303;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // LinkedList 초기화
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i - 1, i + 1));
        }
        nodes.get(0).setLeft(-1);
        nodes.get(nodes.size() - 1).setRight(-1);

        Stack<Integer> archive = new Stack<>();

        int cursor = k;

        for (String command : cmd) {
            if (command.equals("C")) {
                Node curNode = nodes.get(cursor);
                archive.add(cursor);
                curNode.setRemoved(true);

                int left = curNode.getLeft();
                int right = curNode.getRight();

                if (left != -1) {
                    nodes.get(left).setRight(right);
                }

                if (right != -1) {
                    nodes.get(right).setLeft(left);
                }
                cursor = right;
                if (right == -1) {
                    cursor = left;
                }
                continue;
            }

            if (command.equals("Z")) {
                Integer recoverNumber = archive.pop();
                Node recoverNode = nodes.get(recoverNumber);
                recoverNode.setRemoved(false);

                int left = recoverNode.getLeft();
                int right = recoverNode.getRight();

                if (left != -1) {
                    nodes.get(left).setRight(recoverNumber);
                }

                if (right != -1) {
                    nodes.get(right).setLeft(recoverNumber);
                }
                continue;
            }

            String[] splitValue = command.split(" ");

            int moveValue = Integer.parseInt(splitValue[1]);

            while (moveValue-- > 0) {
                if (splitValue[0].equals("U")) {
                    cursor = nodes.get(cursor).getLeft();
                } else {
                    cursor = nodes.get(cursor).getRight();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Node node : nodes) {
            if (!node.isRemoved()) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        return sb.toString();
    }

    static class Node {
        private boolean removed = false;
        private int left;
        private int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean isRemoved() {
            return removed;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public void setRemoved(boolean removed) {
            this.removed = removed;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
            s.solution(8, 2, new String[] {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }
}
