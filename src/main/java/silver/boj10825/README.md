# [BOJ 10825 : 국영수](https://www.acmicpc.net/problem/10825)
- 랭크 : Silver 4
  <br><br>
  
### 문제 정리
- 국어점수(내림차순) -> 영어점수(오름차순) -> 수학점수(내림차순) -> 이름(오름차순)으로 정렬한다.
<br><br>

### 문제 풀이
- 접근 (Main)
  - new Comparator에 각각 같을경우 조건을 집어넣는다.
  - 마지막 string(이름)은 s1.compareTo(s2)로 string 정렬이 가능하다!
    
    


    
    


