# [BOJ 11004 : K번째 수](https://www.acmicpc.net/problem/11004)
- 랭크 : 실버5
  <br><br>
  
### 문제 정리
- 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
- 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다. 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)
   <br><br>

### 문제 풀이
- 접근 1. (Main) : hashmap 사용했으나 시간 초과
- 접근 2. (MainQuickSort) : QuickSort 알고리즘 사용했으나 시간 초과; 아마 채점 방식이 바뀐듯..?
- 접근 3. (MainGeneral) : 걍 일반 소팅 라이브러리 사용.. 통과. 너무 허무하다. Java11에서 sort algorithm이 좋아졌나? 

    
    


    
    


