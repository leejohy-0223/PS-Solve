package DongBinBook;

import java.util.Scanner;

public class ChapEx10_3 {

    // 노드의 개수(V)와 간선(Union)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) { // 큰 쪽의 부모가 작은쪽이 된다.
            parent[b] = a;
        } else
            parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (findParent(a) == findParent(b)) {
                System.out.println("사이클 발생");
                return;
            }
            // 사이클 발생 안했으면 합집합 연산 수행
            unionParent(a, b);
        }
        System.out.println("사이클 발생 안함");
    }
}
