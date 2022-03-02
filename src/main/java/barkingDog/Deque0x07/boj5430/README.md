# [BOJ 5430 : AC](https://www.acmicpc.net/problem/5430)
- 랭크 : Gold 5
  <br><br>

### 문제 정리
-  R(뒤집기), D(버리기)를 활용해서 주어진 배열의 최종 형태를 표현해라.

   <br><br>

### 문제 풀이
- 접근
    - Deque를 이용, R이 나올때마다 방향을 바꾼다. D에서는 방향(앞에서부터 제거 또는 뒤에서부터 제거)에 따라 숫자를 제거한다.
    - 정방향 & 역방향으로 Deque에서 빼는 경우는 다음 스트림을 이용했다.
  
````java
            if (!direction) {
            // 역순으로 스트림 반환
                sb.append(deque.stream()
                    .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream();
                        }))
                    .map(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"))).append("\n");
            // 원래 방향    
            } else {
                sb.append(deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",", "[", "]"))).append("\n");
            }
````