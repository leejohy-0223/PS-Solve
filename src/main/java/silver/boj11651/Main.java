package silver.boj11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Position> arr = new ArrayList<>();
        StringTokenizer st;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            } else
                return o1.y - o2.y;
        });

        StringBuilder sb = new StringBuilder();
        for (Position position : arr) {
            sb.append(position.x).append(" ").append(position.y).append("\n");
        }
        System.out.println(sb);
    }
}
