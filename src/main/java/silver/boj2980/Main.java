package silver.boj2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Sign {
    int[] r;
    int[] g;
    boolean go; // true = green, false = red

    public Sign(int[] r, int[] g, boolean go) {
        this.r = r;
        this.g = g;
        this.go = go;
    }
}

public class Main {
    static Map<Integer, Sign> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());

            map.put(pos, new Sign(new int[red], new int[green], false));
        }

        // initial sign
        for (Integer integer : map.keySet()) {
            Sign sign = map.get(integer);
            sign.g[0] = sign.g.length;
            sign.r[0] = sign.r.length;
        }

        int time = 0;
        int pos = 0;

        while (true) {

            // 시간, position이 정해진 시점에서 체크를 한다.
            if (pos == l) {
                System.out.println(time);
                return;
            }

            if (!map.containsKey(pos)) {
                pos++;
                time++;
                changeSign();
                continue;
            }

            // 해당 위치에 신호등이 있을 경우
            Sign cur = map.get(pos);

            // 현 시점 green이면 출발 가능
            if (cur.go) {
                pos++;
            }

            time++;
            changeSign();

        }
    }

    private static void changeSign() {
        for (Integer integer : map.keySet()) {
            Sign cur = map.get(integer);

            if (cur.go) {
                cur.g[0]--;
            } else {
                cur.r[0]--;
            }

            // green이 0초 남았을 경우
            if (cur.go && cur.g[0] == 0) {
                cur.go = false;
                cur.r[0] = cur.r.length;
                continue;
            }

            // red가 0초 남았을 경우
            if (!cur.go && cur.r[0] == 0) {
                cur.go = true;
                cur.g[0] = cur.g.length;
            }

        }
    }
}
