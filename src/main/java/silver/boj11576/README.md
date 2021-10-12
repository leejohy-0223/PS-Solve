# [BOJ 11576 : Base Conversion](https://www.acmicpc.net/problem/11576)
- 랭크 : Silver 5
  <br><br>
  
### 문제 정리
- 입력으로 주어진 A진법으로 나타낸 수를 B진법으로 변환하여 출력한다.
   <br><br>

### 문제 풀이
- 접근 (Main) : A진수를 10진수로 변경 후, 다시 B진수로 변경한다.
   1. Math.pow를 이용해서 A진수를 10진수로 변경한다. (10진수 결과 : result)
   2. result를 %B, /B를 통해 반복하여 결과를 ArrayList에 넣는다.
   3. 거꾸로 arrayList를 출력한다.  
    
    


    
    


