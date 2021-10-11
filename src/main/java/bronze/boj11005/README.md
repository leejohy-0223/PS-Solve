# [BOJ 11005 : 진법 변환 2](https://www.acmicpc.net/problem/11005)
- 랭크 : Bronze 1
  <br><br>
  
### 문제 정리
1. N을 B진법으로 나타낸다. 10 이상의 수일 경우, A ~ Z 알파벳으로 변환해서 출력한다.
   <br><br>

### 문제 풀이
- 접근 1. (Main) : stack을 이용한다.
<br><br>
  
- 접근 2. (MainReverse) N % B의 결과가 10보다 작으면 Stringbuilder에 넣는다. 크다면 Stringbuilder에 +55만큼 더한 후 (char)로 casting해서 넣는다. 마지막으로 sb.reverse()를 통해 거꾸로 출력한다.

    


    
    


