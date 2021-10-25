package silver.boj1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int count;
    int older;
    int saveIdx;

    public Student(int count, int older, int saveIdx) {
        this.count = count;
        this.older = older;
        this.saveIdx = saveIdx;
    }
}

public class Main {
    static Map<Integer, Student> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        int[] sazin = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        int older = 0;
        while (s-- > 0) {
            int tmp = Integer.parseInt(st.nextToken());
            if (idx < N) {
                if (map.containsKey(tmp)) { // map에 tmp가 있으면 count만 증가시킨다.
                    map.get(tmp).count++;
                } else {
                    sazin[idx] = tmp; // map에 tmp가 없으면 idx에 직접 넣고, map에도 새로 넣는다.
                    map.put(tmp, new Student(1, older, idx));
                    older++;
                    idx++;
                }
                continue;
            }

            // 이미 배열에 있다면, 그 부분을 처리한다.
            if (map.containsKey(tmp)) {
                map.get(tmp).count++;
                continue;
            }

            // 하나를 대체해야 하므로 아래와 같은 처리를 진행한다.
//            int min = Integer.MAX_VALUE;
//            List<Integer> list = new ArrayList<>();
//            // 앞에서 부터 가장 작은 count를 확인
//            for (int key : sazin) {
//                if (min > map.get(key).count) {
//                    list.clear();
//                    min = map.get(key).count;
//                    list.add(key);
//                } else if (min == map.get(key).count) {
//                    list.add(key);
//                }
//            }
//
//            int key = list.get(0);
//
//            // size가 1이 아닐때만 이 처리를 한다.
//            if (list.size() != 1) {
//                int old = map.get(key).older;
//                for (Integer i : list) {
//                    if (old > map.get(i).older) {
//                        old = map.get(i).older;
//                        key = i;
//                    }
//                }
//            }

//            // 가장 적은 추천을 받은 수(key)를 tmp로 대체한다.
//            sazin[map.get(key).saveIdx] = tmp;
//            map.put(tmp, new Student(1, older, map.get(key).saveIdx));
//
//            // 기존 key를 제거한다.
//            map.remove(key);
//            older++;

            // 꽉 찼다면,

            for (int i : sazin) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

//        Arrays.sort(sazin);
//
//        for (int i : sazin) {
//            System.out.print(i + " ");
//        }

    }
}
