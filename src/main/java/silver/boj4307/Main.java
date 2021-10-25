package silver.boj4307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < num; i++) {
                int tmp = Integer.parseInt(br.readLine());
                list.add(tmp);

                if (min > tmp) {
                    min = tmp;
                }

                if (max < tmp) {
                    max = tmp;
                }
            }

            int left = L / 2, right = L / 2;
            if (list.contains(L / 2)) {
                sb.append(L / 2).append(" ");
            } else {
                while (left-- > 0) {
                    if (list.contains(left)) {
                        break;
                    }
                }
                while (right++ < L) {
                    if (list.contains(right)) {
                        break;
                    }
                }
                if (left > L - right) {
                    if (left != 0) {
                        sb.append(left).append(" ");
                    } else
                        sb.append(1).append(" ");
                } else {
                    if (right != L) {
                        sb.append(L - right).append(" ");
                    } else
                        sb.append(1).append(" ");
                }
            }

            if (L - min > max) {
                sb.append(L - min).append("\n");
            } else
                sb.append(max).append("\n");

        }
        System.out.println(sb);
    }
}
