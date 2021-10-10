package silver.boj2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<String> set = new HashSet<>();
    static int[] quantity = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        quantity[0] = Integer.parseInt(st.nextToken());
        quantity[1] = Integer.parseInt(st.nextToken());
        quantity[2] = Integer.parseInt(st.nextToken());

        // 처음에는 0, 0, 10
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.offer(new int[]{0, 0, quantity[2]});
        arrayList.add(quantity[2]);

        StringBuilder sb = new StringBuilder();
        String s = sb.append(0).append(0).append(quantity[2]).toString();
        set.add(s);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();

                for (int j = 0; j < 3; j++) {
                    if(poll[j] != 0) {
                        for (int k = 0; k < 3; k++) {
                            if(k != j) {
                                int cQ = poll[j]; // 가용한 물 양 : 10
                                int targetQ = poll[k]; // 타겟의 현재 물 양 : 0
                                int[] copy = poll.clone();

                                // 타겟이 필요한 양
                                int need = quantity[k] - targetQ;

                                // 필요량이 cQ보다 많다면,
                                if(need > cQ) {
                                    targetQ += cQ;
                                    cQ = 0;
                                } else { // 필요량이 cQ보다 적다면,
                                    targetQ += need;
                                    cQ -= need;
                                }
                                copy[j] = cQ;
                                copy[k] = targetQ;
                                // 변경 후, 기존에 검사한건지 확인
                                String tmp = arrayToString(copy);
                                if (!set.contains(tmp)) {
                                    set.add(tmp);
                                    if(copy[0] == 0 && !arrayList.contains(copy[2])) {
                                        arrayList.add(copy[2]);
                                    }
                                    queue.offer(copy);
                                }
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : arrayList) {
            stringBuilder.append(integer).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private static String arrayToString(int[] copy) {
        StringBuilder sb = new StringBuilder();
        for (int i : copy) {
            sb.append(i);
        }
        return sb.toString();
    }
}
