package silver.boj2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Arcade {
    int direction;
    int distance;

    public Arcade(int direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
}

public class Main {
    static int sum = 0;
    static int w, h, n;
    static Arcade home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());

        List<Arcade> list = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Arcade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        home = new Arcade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (Arcade target : list) {
            sum += calDistance(target);
        }
        System.out.println(sum);
    }

    private static int calDistance(Arcade target) {

        int d = target.direction;
        int s = home.direction;

        switch (s) {
            case 1: // 1, 3, 4는 바로 계산 & 2는 양방향 계산 필요
                if(d == 1) {
                    return Math.abs(home.distance - target.distance);
                }
                if (d == 3) {
                    return (home.distance + target.distance);
                }
                if (d == 4) {
                    return (w - home.distance + target.distance);
                }
                if (d == 2) {
                    return Math.min(home.distance + h + target.distance, w - home.distance + h + w - target.distance);
                }
            case 2: // 2, 3, 4는 바로 계산, 1은 양방향 계산 필요
                if (d == 2) {
                    return Math.abs(home.distance - target.distance);
                }
                if (d == 3) {
                    return (home.distance + h - target.distance);
                }
                if (d == 4) {
                    return (w - home.distance + h - target.distance);
                }
                if (d == 1) {
                    return Math.min(home.distance + h + target.distance, w - home.distance + h + w - target.distance);
                }
            case 3: // 3, 1, 2는 바로 계산, 4는 양방향 계산
                if (d == 3) {
                    return Math.abs(home.distance - target.distance);
                }
                if (d == 1) {
                    return (home.distance + target.distance);
                }
                if (d == 2) {
                    return (h - home.distance + target.distance);
                }
                if (d == 4) {
                    return Math.min(home.distance + w + target.distance, h - home.distance + w + h - target.distance);
                }
            case 4: // 1, 2, 4는 바로 계산, 3은 양방향 계산
                if (d == 4) {
                    return Math.abs(home.distance - target.distance);
                }
                if (d == 1) {
                    return (home.distance + w - target.distance);
                }
                if (d == 2) {
                    return (h - home.distance + w - target.distance);
                }
                if (d == 3) {
                    return Math.min(home.distance + w + target.distance, h - home.distance + w + h - target.distance);
                }
        }
        return 0;
    }
}
