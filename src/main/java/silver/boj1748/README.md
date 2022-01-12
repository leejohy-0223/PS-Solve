# [BOJ 1748 : 수 이어 쓰기 1](https://www.acmicpc.net/problem/1748)
- 랭크 : Silver 3
  <br><br>
  
### 문제 정리
-  1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
   (1234567891011121314151617181920212223...)
-  이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

   <br><br>

### 문제 풀이
- 접근 (Main) : 규칙을 찾는다.
   - 1 ~ 9 : 1자리(9개)
   - 10 ~ 99 : 2자리(90개)
   - 100 ~ 999 : 3자리(900개)
   - 1000 ~ 9999 : 4자리(9000개)
 
- 현재 수에서, 자리수를 알아내고 stopper(4자리라면 1000)을 구해 해당 자리까지 개수를 계산한다.
- 자리수가 1자리가 될 때까지 위의 규칙으로 나머지를 더해준다.
    
    


    
    

