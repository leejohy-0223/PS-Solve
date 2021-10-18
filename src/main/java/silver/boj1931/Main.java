package silver.boj1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Conf{
    int start;
    int end;

    public Conf(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Conf> list = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Conf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int count = 1;
        int finishLine = list.get(0).end;

        for (int i = 1; i < list.size(); i++) {
            Conf temp = list.get(i);
            if (temp.start >= finishLine) {
                finishLine = temp.end;
                count++;
            }
        }

        System.out.println(count);

    }
}
