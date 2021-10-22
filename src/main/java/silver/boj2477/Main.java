package silver.boj2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Around {
    int direction;
    int length;

    public Around(int direction, int length) {
        this.direction = direction;
        this.length = length;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Queue<Around> queue = new LinkedList<>();

        int seroMax = 0;
        int garoMax = 0;

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (dir == 4 || dir == 3) {
                seroMax = Math.max(seroMax, len);
            } else
                garoMax = Math.max(garoMax, len);
            queue.offer(new Around(dir, len));
        }

        int seroMin = 0;
        int garoMin = 0;

        while (true) {
            Around poll = queue.poll();
            if (poll.length != seroMax && poll.length != garoMax) {
                queue.offer(poll);
                continue;
            }

            // 세로 먼저 처리
            if (poll.direction == 3 || poll.direction == 4) {
                Around poll2 = queue.poll();
                // 만약 얘도 장변이라면, 다다음에 가로 단변이 있다.
                if (poll2.length == garoMax) {
                    queue.add(queue.poll()); // 하나는 버리고,
                    garoMin = queue.poll().length; // 가로 갱신
                    seroMin = queue.poll().length; // 세로 갱신
                } else { // 단변이었다면, 다음에 세로 단변이 있다.
                    seroMin = queue.poll().length;
                    garoMin = queue.poll().length;
                }
                break;
            }

            // 가로  처리
            Around poll2 = queue.poll();
            // 만약 얘도 장변이라면, 다다음에 세로 단변이 있다.
            if (poll2.length == seroMax) {
                queue.add(queue.poll()); // 하나는 버리고,
                seroMin = queue.poll().length; // 세로 갱신
                garoMin = queue.poll().length; // 가로 갱신
            } else { // 단변이었다면, 다음에 가로 단변이 있다.
                garoMin = queue.poll().length;
                seroMin = queue.poll().length;
            }
            break;
        }

        System.out.println(k * ((garoMax * seroMax) - (garoMin * seroMin)));

    }
}
