# [BOJ 1240 : 노드 사이의 거리](https://www.acmicpc.net/problem/124-)
- 랭크 : Gold 5
  <br><br>
  
### 문제 정리
- 노드로 이루어진 트리가 주어진다.
- 두 노드의 사이 거리도 주어질 때, 입력된 두 노드쌍에 대한 거리를 출력한다.
<br><br>

### 문제 풀이
- 접근 (Main)
    - dfs로 접근했다.
    - 이차원 배열에 노드 정보를 넣었다. 이렇게 하면 연결 안된 부분도 모두 탐색해야 한다.
    - 시간이 무지 오래 걸렸다.
  

- 접근 (MainRef)
    - bfs로 접근했다.
    - ArrayList<ArrayList<Node>>를 만들어서 양방향 연관관계를 만들어 풀었다.
    - 탐색 중 타겟 노드가 나오면 정지한다.
    - 이 때는 BFS 진행 시 깊이에 대한 개념이 필요없다. 따라서 size를 따로 뽑아서 for문을 돌릴 필요가 없다.
  

- 접근 (MainRefDfs)
    - 다시 dfs로 접근했다.
    - ArrayList<ArrayList<Node>>를 활용했다.
    - 탐색 중 타겟이 나오면 sb에 dist를 입력하고 return 한다.
    - BFS보다 더 빠르다.
  
- 추가 참고 : LCA 알고리즘(최소 공통 조상 노드를 찾는 알고리즘) 활용하면 더 빠르다.

    
    

