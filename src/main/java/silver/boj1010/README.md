# BOJ 1010 : 다리 놓기
- 랭크 : 실버5
- [백준 1010](https://www.acmicpc.net/problem/1010)
  <br><br>
  
### 문제 정리
1. m개의 다리 중 n개를 cross되지 않도록 선택해라. combination을 사용한다.
2. 시간초과에 주의한다.
   <br><br>

### 문제 풀이
- 접근 1 : dfs로 접근 후 이전에 선택된 노드 이후의 것들만 선택되도록 구현하였다. 시간 초과가 발생했다.
- 접근 2(Main.java) : factorial을 통해 nCr(조합)을 구현하였다.
- 접근 3(MainDp.java) : dp(bottom-up / 반복문)을 통해 구현하였다. 
   - (n, r) = (n-1, r-1) + (n-1, r) 및 (n, 0) == (n, n) == 1을 통해 구현했다.
    
### 알게된 점
- 접근 2 방식으로 팩토리얼을 모두 구하는 방식에서는, 매우 큰 수를 저장 할 자료형이 필요하다. 이 때 BigInteger 자료형을 사용한다.
- BigInteger 클래스에는 다양한 메소드가 있다. 

```java
BigInteger zero = BigInteger.ZERO; // 0
BigInteger one = BigInteger.ONE; // 1
BigInteger ten = BigInteger.TEN; // 10
    
BigInteger add = zero.add(one); // 더하기
BigInteger sub = zero.subtract(one); // 빼기
BigInteger mul = zero.multiply(one); // 곱하기
BigInteger div = zero.divide(ten); // 나누기

add.valueOf(28); // BigInteger 대상 일반 자료형 add
```
