package silver.boj1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] swc = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                swc[i] = true;
            }
        }

        int number = Integer.parseInt(br.readLine());

        while (number-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int have = Integer.parseInt(st.nextToken());

            // 남
            if (sex == 1) {
                for (int i = have; i <= n; i += have) {
                    swc[i] = !swc[i];
                }
                continue;
            }

            // 여
            int left = have - 1;
            int right = have + 1;

            if (left >= 1 && right <= n && swc[left] == swc[right]) {
                while (true) {
                    left--;
                    right++;

                    if (left >= 1 && right <= n && swc[left] == swc[right]) {
                        continue;
                    }
                    left++;
                    right--;
                    break;
                }
                for (int i = left; i <=right ; i++) {
                    swc[i] = !swc[i];
                }
            } else {
                swc[have] = !swc[have];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(swc[i]) {
                sb.append(1).append(" ");
            } else
                sb.append(0).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
