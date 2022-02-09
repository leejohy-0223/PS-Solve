package DongBinBook;

import java.util.Scanner;

public class ChapEx10_2 {

    // 노드의 개수(V)와 간선(Union)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 찾을 때까지 재귀로 호출
        // 루트노드라 함은, 노드와 부모테이블의 노드가 일치함을 의미한다.
        if(x == parent[x]) {
            return x;
        }
        /**
         * 개선 : 재귀로 호출한 후에 부모 테이블을 갱신.
         * 이를 통해 각 노드에 대해 findParent를 호출한 후, 해당 노드의 루트노드가 바로 부모가 된다.
         * 즉 부모테이블을 모두 루트 노드로 갱신한다.
         */
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

        // Union 연산 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // 루트를 찾아서 연결해주기
        for (int i = 1; i <= v; i++) {
            findParent(i);
        }

        // 갱신된 부모테이블 출력하기
        System.out.print("부모 테이블 : ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
    }


}
