package AlgorithmStudy.boj1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Picture> pq = new PriorityQueue<>();
        Set<Integer> candidate = new HashSet<>();

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            // aging
            for (Picture picture : pq) {
                picture.age++;
            }

            int vote = Integer.parseInt(s[i]);
            if (candidate.size() != N) {
                pq.add(new Picture(vote, 0, 1));
                candidate.add(vote);
                continue;
            }

            // 후보자가 지금 리스트에 걸려있을 경우
            if (candidate.contains(vote)) {
                for (Picture picture : pq) {
                    if (picture.candidate == vote) {
                        int age = picture.age;
                        int nomination = picture.nomination;
                        pq.remove(picture);
                        pq.add(new Picture(vote, age, nomination + 1));
                        break;
                    }
                }
                continue;
            }

            // 아닐 경우
            Picture poll = pq.poll();
            candidate.remove(poll.candidate);
            pq.add(new Picture(vote, 0, 1));
            candidate.add(vote);
        }

        ArrayList<Integer> integers = new ArrayList<>(candidate);

        Collections.sort(integers);

        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    static class Picture implements Comparable<Picture> {
        int candidate;
        int age;
        int nomination;

        public Picture(int candidate, int age, int nomination) {
            this.candidate = candidate;
            this.age = age;
            this.nomination = nomination;
        }

        @Override
        public int compareTo(Picture o) {
            if (this.nomination == o.nomination) {
                return o.age - this.age;
            }
            return o.nomination - this.nomination;
        }
    }
}
