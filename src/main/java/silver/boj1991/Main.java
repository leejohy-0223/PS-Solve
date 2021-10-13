package silver.boj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    Node root; // 루트 노드 처음에는 null 상태

    // 값을 추가하는 메서드
    public void createNode(char data, char leftData, char rightData) {
        if (root == null) { // 아무것도 없는 초기 상태 - A루트 노드 생성
            root = new Node(data);

            // 좌, 우 값이 있는 경우에만 노드 생성
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else { // 초기 상태가 아니라면 어디에 들어가야할지 찾아야 함, 즉 루트 이후에는 여기에서 추가된다
            searchNode(root, data, leftData, rightData);
        }
    }

    // 값을 어느 위치에 추가할 것인지 찾기 위한 메서드
    public void searchNode(Node root, char data, char leftData, char rightData) {
        if (root == null) { // 도착한 노드가 null이면 재귀 종료
            return;
        } else if (root.data == data) { // 들어갈 위치를 찾았다면..?
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else { // 탐색할 노드가 남아잇다면,
            searchNode(root.left, data, leftData, rightData);
            searchNode(root.right, data, leftData, rightData);
        }
    }

    // 전위 순회 : Root -> left -> right
    public void preOrder(Node node) {
        if (node != null) {
            if(node.data != '.') {
                System.out.print(node.data);
            }
            if (node.left != null) preOrder(node.left);
            if (node.right != null) preOrder(node.right);
        }
    }

    // 중위 순회 : left -> Root -> right
    public void inOrder(Node node) {
        if (node != null) {
            if (node.left != null) inOrder(node.left);
            if(node.data != '.') {
                System.out.print(node.data);
            }
            if (node.right != null) inOrder(node.right);
        }
    }

    // 후위 순회 : left -> right -> root
    public void postOrder(Node node) {
        if (node != null) {
            if (node.left != null) postOrder(node.left);
            if (node.right != null) postOrder(node.right);
            if(node.data != '.') {
                System.out.print(node.data);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Tree t = new Tree();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            t.createNode(a, b, c);
        }

        t.preOrder(t.root);
        System.out.println();

        t.inOrder(t.root);
        System.out.println();

        t.postOrder(t.root);
        System.out.println();
    }
}
