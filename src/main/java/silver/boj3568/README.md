# [BOJ 3568 : iSharp](https://www.acmicpc.net/problem/3568)
- 랭크 : 실버 4
  <br><br>
  
### 문제 정리
- int& a*[]&, b, c*; -> int&&[]* a; int& b; int&* c;와 같이 출력해라.
- 맨 앞에는 공통 기본 변수, 뒤에는 변수명 + 추가변수형태로 오게 된다.
- 변수 오른편에 있는 변수형은 순서를 뒤집어서 왼편에 붙여야 한다.
   <br><br>

### 문제 풀이
- 접근 (Main) 
   - Stringbuilder.reverse를 이용해서 공통변수 + 추가변수 + " " + 변수명; 형태로 출력하면 된다.
   - []의 경우, ][로 뒤집혀 나오므로 replace 메서드를 사용해서 구현한다.

  

    
    


    
    


