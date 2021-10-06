# [BOJ 10610 : 30](https://www.acmicpc.net/problem/10610)
- 랭크 : 실버5
  <br><br>
  
### 문제 정리
1. 주어진 숫자가 30의 배수인지 확인 한 후, 숫자를 조합해서 가장 큰 30의 배수를 출력한다.
2. 길이가 10^5이므로 매우 큼에 유의한다.   
   <br><br>

### 문제 풀이
- 접근 1(Main)
  1. 30의 배수이기 위해서는, 모든 자리수의 합이 3의 배수여야 한다.
  2. 또한 30의 배수이기 위해서는 0을 포함해야 한다. 자리수 합을 구하는 과정에서 0이 안나오면 -1을 반환했다.
  - String -> Integer -> String 하는 과정에서 시간이 오래 걸린 듯 하다.
    <br><br>
    

- 접근 2(MainCharSorting)
  - 이번에는 CharArray에서 sorting을 진행했다(오름차순). 맨 처음 수가 0이 아니면 -1을 반환한다.
  - 마찬가지로 sum을 구한다. 이 과정에서 Integer.parseInt 대신 char - '0'을 통해 구했다. (parseInt로 charArray 변경은 불가능하다.)
  - new StringBuilder(String.valueOf(N)).reverse()를 통해 간단히 char배열 "N"을 reverse로 sorting할 수 있다.
  
  

    
    


    
    


