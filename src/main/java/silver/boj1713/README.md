# [BOJ 1713 : 후보 추천하기](https://www.acmicpc.net/problem/1713)
- 랭크 : Silver 2
  <br><br>
  
### 문제 정리
- 사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다.

   <br><br>

### 문제 풀이
- 접근 (Main) : 오답
- 접근 2(MainRef) 
    - value, count, age(들어온 시간)을 가지는 Student class를 생성하고, count / age에 맞게 compareTo를 오버라이딩 한다.
    - 기존에 있는 후보인 경우 count만 올린다. 매번 Sorting을 진행해야 함에 유의한다!!
    - 기존에 없는 후보인 경우, 꽉 찼을 경우 vs 여유가 있을 경우로 나눠서 처리한다.
    - 꽉 찼을 경우, 매번 sorting 되어있는 상태이므로 맨 앞 후보를 지우고 list에 add하면 된다.
    - 마지막으로 출력 시 value 기준 오름차순으로 출력한다.
  


    
    


    
    


