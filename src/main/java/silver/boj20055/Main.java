package silver.boj20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int beltLen = (n << 1);
        int[] arr = new int[beltLen];
        boolean[] robotChk = new boolean[beltLen];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beltLen; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 구현 시작
        boolean pass = true; // 모든 내구도 정상
        int pointer = 0;
        int last = n - 1;
        int stage = 0;
        while (pass) {

            // 0. stage를 한 단계 올린다.
            stage++;

            // 0.1 마지막에 있었던 로봇을 내린다.
            robotChk[last] = false;

            // 1. pointer를 내린다
            if (pointer == 0) {
                pointer = beltLen - 1;
            } else {
                pointer--;
            }

            // 1.1 last도 변경한다.
            if (last == 0) {
                last = beltLen - 1;
            } else {
                last--;
            }

            // * last의 로봇은 즉시 내린다.
            robotChk[last] = false;

            // 2. 로봇을 이동시킨다.
            // pointer가 last보다 클 경우 처리
            if (pointer > last) {
                for (int i = last - 1; i >= 0; i--) {
                    if (!robotChk[i]) continue;

                    int nextIdx = i + 1;

                    // 로봇이 다음칸에 존재하거나 내구성이 없으면 continue
                    if (robotChk[nextIdx] || arr[nextIdx] == 0) continue;

                    robotChk[nextIdx] = true;
                    arr[nextIdx]--;
                    robotChk[i] = false;
                }

                for (int i = beltLen - 1; i >= pointer; i--) {
                    if (!robotChk[i]) continue;

                    // 다음 인덱스가 2 * n을 넘어가면 이는 0을 의미한다.
                    int nextIdx = i + 1;
                    if (nextIdx >= beltLen) {
                        nextIdx = 0;
                    }

                    // 로봇이 다음칸에 존재하거나 내구성이 없으면 continue
                    if (robotChk[nextIdx] || arr[nextIdx] == 0) continue;

                    robotChk[nextIdx] = true;
                    arr[nextIdx]--;
                    robotChk[i] = false;
                }
            } else {
                for (int i = last - 1; i >= pointer; i--) {
                    if (!robotChk[i]) continue;

                    int nextIdx = i + 1;

                    // 로봇이 다음칸에 존재하거나 내구성이 없으면 continue
                    if (robotChk[nextIdx] || arr[nextIdx] == 0) continue;

                    robotChk[nextIdx] = true;
                    arr[nextIdx]--;
                    robotChk[i] = false;
                }
            }

            // 3. 올리는 위치에 로봇을 올린다.
            if (arr[pointer] > 0) {
                robotChk[pointer] = true;
                arr[pointer]--;
            }

            // 4. 전체 내구도를 검사한다.
            int count = 0;
            for (int i = 0; i < beltLen; i++) {
                if (arr[i] == 0) {
                    count++;
                }
                if (count == k) {
                    pass = false;
                }
            }
        }
        System.out.println(stage);
    }
}
