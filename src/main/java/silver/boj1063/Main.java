package silver.boj1063;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static Map<String, Position> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 움직임 위치 고정
        map.put("R", new Position(0, 1));
        map.put("RB", new Position(-1, 1));
        map.put("B", new Position(-1, 0));
        map.put("LB", new Position(-1, -1));
        map.put("L", new Position(0, -1));
        map.put("LT", new Position(1, -1));
        map.put("T", new Position(1, 0));
        map.put("RT", new Position(1, 1));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            String s = br.readLine();
            Position addPos = map.get(s);

            // 새로운 위치 추출
            char ny = (char) (king.charAt(0) + addPos.y);
            int nx = (king.charAt(1) - 48) + addPos.x;

            // 새 위치가 범위 밖일경우 continue
            if(ny < 'A' || ny > 'H' || nx < 1 || nx > 8) continue;

            String nk = ny + "" + nx;

            // 새 위치에 돌이 있을 경우, 돌의 새로운 위치 계산
            if(nk.equals(stone)) {
                char sy = (char) (king.charAt(0) + 2 * addPos.y);
                int sx = (king.charAt(1) - 48) + 2 * addPos.x;
                // 돌 위치도 범위 밖일경우 continue
                if(sy < 'A' || sy > 'H' || sx < 1 || sx > 8) continue;

                stone = sy + "" + sx;
            }
            king = nk;
        }
        System.out.println(king);
        System.out.println(stone);
    }
}
