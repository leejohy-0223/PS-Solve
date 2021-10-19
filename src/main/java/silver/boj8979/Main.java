package silver.boj8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Medal {
    int nation;
    int g;
    int s;
    int b;

    public Medal(int nation, int g, int s, int b) {
        this.nation = nation;
        this.g = g;
        this.s = s;
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Medal> list = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Medal(nation, gold, silver, bronze));
        }

        list.sort((o1, o2) -> {
            if (o1.g == o2.g) {
                if (o1.s == o2.s) {
                    return o2.b - o1.b;
                }
                return o2.s - o1.s;
            }
            return o2.g - o1.g;
        });

        int rank = 1;
        int rc = 0; // rand count

        Medal ref = list.get(0);
        for (Medal cur : list) {
            if (compareMedal(ref, cur)) {
                rc++;
            } else {
                rank += rc;
                rc = 1;
                ref = cur;
            }

            if (cur.nation == M) {
                System.out.println(rank);
                return;
            }
        }

    }

    private static boolean compareMedal(Medal ref, Medal cur) {
        return ref.g == cur.g && ref.s == cur.s && ref.b == cur.b;
    }
}
