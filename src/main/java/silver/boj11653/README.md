# [BOJ 11653 : 소인수분해](https://www.acmicpc.net/problem/11653)
- 랭크 : Silver 4
  <br><br>
  
### 문제 정리
- 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

### 문제 풀이
- 접근 (Main)
   - sqrt 말고, i*i<=N으로 변경했다.(i <= sqrt(N)   =>   i x i <= N )
   - i를 2부터 올리며 몫을 stringbuilder에 넣는다.
   - 마지막 몫이 1이 아닐 경우, 그 값을 stringbuilder에 추가하고 반환한다. 
    

    


    
    


