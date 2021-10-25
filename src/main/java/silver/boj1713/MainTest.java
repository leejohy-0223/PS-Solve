package silver.boj1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainTest {

    static class Student implements Comparable<Student> {
        int val, count, age;

        public Student(int val, int count, int age) {
            this.val = val;
            this.count = count;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count == o.count) {
                return this.age - o.age;
            }
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {

            int tmp = Integer.parseInt(st.nextToken());

            boolean isHere = false;
            for (Student s : list) {
                if (s.val == tmp) {
                    s.count++;
                    isHere = true;
                    break;
                }
            }
            if (!isHere) {
                // list가 꽉 차지 않았을 경우,
                if (list.size() != N) {
                    list.add(new Student(tmp, 1, i));
                    continue;
                }

                // list가 꽉 찼을 경우, 맨 앞에 제거 후 새로 넣기
                list.remove(list.get(0));
                list.add(new Student(tmp, 1, i));
            }
            Collections.sort(list);
        }

        list.sort(Comparator.comparingInt(o -> o.val));

        for (Student student : list) {
            System.out.print(student.val + " ");
        }
    }
}
