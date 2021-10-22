# [BOJ 1063 : 킹](https://www.acmicpc.net/problem/1063)
- 랭크 : Sliver 4
  <br><br>
  
### 문제 정리
- 입력으로 킹이 어떻게 움직여야 하는지 주어진다. 
- 입력으로 주어진 대로 움직여서 킹이나 돌이 체스판 밖으로 나갈 경우에는 그 이동은 건너 뛰고 다음 이동을 한다.
킹과 돌의 마지막 위치를 구하는 프로그램을 작성하시오.
   <br><br>

### 문제 풀이
- 접근  
   - 킹이 움직일 수 있는 8방향을 map에 저장했다.
   - 새로운 위치를 계산해서 추출하고, 조건에 맞게 걸러낸다. 
       1. 새로운 위치가 범위 밖이면 continue
       2. 새 위치에 돌이 있을 경우, 돌의 위치 변경 시 그 위치가 범위 밖이면 continue
       3. 둘 다 통과하면 킹, 돌 위치 갱신 후 반복
