package silver.boj10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Student {
    String name;
    int k;
    int e;
    int m;

    public Student(String name, int k, int e, int m) {
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public int getK() {
        return k;
    }

    public int getE() {
        return e;
    }

    public int getM() {
        return m;
    }
}

public class Main {

    static ArrayList<Student> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = getK(br.readLine());

        StringTokenizer st;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            arrayList.add(new Student(st.nextToken(), getK(st.nextToken()), getK(st.nextToken()), getK(st.nextToken())));
        }

        arrayList.sort((o1, o2) -> {
            if(o1.getK() == o2.getK()) {
                if(o1.getE() == o2.getE()) {
                    if(o1.getM() == o2.getM()) {
                        return o1.getName().compareTo(o2.getName());
                    }
                    return o2.getM() - o1.getM();
                }
                return o1.getE() - o2.getE();
            }
            return o2.getK() - o1.getK();
        });

        StringBuilder sb = new StringBuilder();
        arrayList.forEach(o -> sb.append(o.name).append("\n"));
        System.out.println(sb);
    }

    private static int getK(String s) {
        return Integer.parseInt(s);
    }
}
