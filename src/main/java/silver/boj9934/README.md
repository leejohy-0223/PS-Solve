# [BOJ 9934 : 완전 이진 트리](https://www.acmicpc.net/problem/9932)
- 랭크 : Silver 1
  <br><br>
  
### 문제 정리
- 중위 순회 결과로 나와 있는 완전 이진 트리를 각 높이마다 출력하면 된다.
   <br><br>

### 문제 풀이
- 접근 (Main) 
   - 반으로 나누면, 중간값이 부모노드이다. 각 depth마다 Stringbuilder를 만들기 위해 Stringbuilder 배열을 이용한다.
   - 각 depth에 맞게 mid값을 Stringbuilder에 넣고, depth를 증가시키며 재귀호출을 진행한다.
   - 최종적으로 left == right라는 건 값 하나밖에 없으므로 해당 depth에 값을 넣고 return 한다. 
  
- 접근 (MainRef)
   - left, right 정보를 가지는 Point 클래스를 가지고, 큐에 넣어 반복을 진행한다. 
   - 재귀가 복잡하면 이렇게 접근해보자. 
    

    
    


    
    


