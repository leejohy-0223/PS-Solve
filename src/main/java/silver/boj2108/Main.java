package silver.boj2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] count = new int[8001];
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        value = new int[n];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
            count[value[i] + 4000]++;
            sum += value[i];
            min = Math.min(min, value[i]);
            max = Math.max(max, value[i]);
        }

        Arrays.sort(value); //오름차순 정렬

        StringBuilder sb = new StringBuilder();

        //1. 산술 평균 출력

        sb.append(Math.round((double) sum / n)).append("\n");

        //2. 중앙값 출력
        sb.append(value[n / 2]).append("\n");

        //3. 최빈값 출력
        int max_value = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (max_value < count[i]) {
                max_value = count[i];
            }
        }

        for (int i = 0; i < 8001; i++) {
            if (count[i] == max_value) {
                list.add(i);
            }
        }

        Collections.sort(list);
        if(list.size() == 1) {
            sb.append(list.get(0) - 4000).append("\n");
        } else {
            sb.append(list.get(1) - 4000).append("\n");
        }


        /* 참고 코드
        		for(int i=0;i<8001;i++) {
			if(mode<data[i]) { mode = data[i]; list.clear(); list.add(i);}
			else if(mode==data[i]) {list.add(i);}
			accumulate+=data[i];
			if(calmedianValue==false && accumulate>=half) {
				medianValue = i-4000;
				calmedianValue = true;
			}
		}
         */

        // 4. 범위 출력
        sb.append(max - min);
        System.out.println(sb);
    }
}
