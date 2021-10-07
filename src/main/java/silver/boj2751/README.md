# [BOJ 2751 : 수 정렬하기 2](https://www.acmicpc.net/problem/2751)
- 랭크 : 실버5
  <br><br>
  
### 문제 정리
1. 자연수 M, N이 주어질 때, M이상 N이하의 자연수 중 소수인 것을 찾는 문제이다.
2. 값이 있다면 이들의 합, 가장 작은 소수를 출력한다.
3. 값이 없다면 -1만 출력한다.
4. 중요한 건 자연수가 중복이 되지 않는다는 점이며, 절대값이 1,000,000보다 작거나 같은 정수이므로 음수도 해당된다.
   <br><br>

### 문제 풀이
- 접근
  - sort 메서드 구현 : 시간 초과
  - boolean 이용
      1. 2,000,000 크기의 boolean 배열을 만든다.
      2. 입력된 숫자 + 1,000,000에 해당하는 index를 true로 변경한다. 이 방식으로 음수도 표현할 수 있다.
      3. boolean 배열 전체를 탐색하며, true인 값만 출력한다. 이 때 원래 값을 추출하기 위해 -1,000,000을 적용해서 출력한다.
  

    
    


    
    

