# [BOJ 1758 : 알바생 강호](https://www.acmicpc.net/problem/1758)
- 랭크 : Silver 4
  <br><br>
  
### 문제 정리
1. 손님들은 입구에 들어갈 때, 강호에게 팁을 준다. 손님들은 자기가 커피를 몇 번째 받는지에 따라 팁을 다른 액수로 강호에게 준다. 각 손님은 강호에게 원래 주려고 생각했던 돈 - (받은 등수 - 1) 만큼의 팁을 강호에게 준다. 만약, 위의 식으로 나온 값이 음수라면, 강호는 팁을 받을 수 없다.
   <br><br>

### 문제 풀이
- 접근 (Main) : 들어오는 순서만큼 원래 주려던 돈에서 깎는 방식으로 팁을 계산해서 반환한다.
쉽게 구현되지만, 팁의 최댓값이 100,000이므로 result를 Int가 아닌 long으로 선언해서 풀자.
    
    


    
    

