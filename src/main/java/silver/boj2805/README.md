# [BOJ 2805 : 나무 자르기](https://www.acmicpc.net/problem/2805)
- 랭크 : Silver 3
  <br><br>
  
### 문제 정리
- 자르는 양을 최소화 하면서, 원하는 나무의 양을 얻을 수 있는 톱의 높이를 구하는 문제이다.
   <br><br>

### 문제 풀이
- 접근 (Main) : 이분 탐색 & 상한 사용
  - 잘리는 양(count) > 필요 양(n) -> lo를 높여 mid를 올린 후, 잘리는 양을 줄인다.(lo = mid + 1)
  - 잘리는 양(count) < 필요 양(n) -> hi를 낮춰 mid를 내린 후, 잘리는 양을 늘린다.(hi = mid)
  - 잘리는 양(count) = 필요 양(n) -> 높이는 최대여야 한다. 따라서 여기에서도 lo를 높인다.(lo = mid + 1)
  

    
    


    
    

