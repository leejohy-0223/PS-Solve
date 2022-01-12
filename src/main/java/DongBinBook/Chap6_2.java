package DongBinBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Chap6_2 {

    static class Score {
        String name;
        int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Score> list = new ArrayList<>();

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        list.sort(Comparator.comparingInt(o -> o.score));
        list.forEach(c -> System.out.print(c.name + " "));
    }
}
