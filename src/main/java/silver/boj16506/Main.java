package silver.boj16506;

public class Main {
    public static void main(String[] args) {
        int a = 5;

        // a를 3bit binary로 만들기
        String s = Integer.toBinaryString(3);

        if (s.length() == 1) {
            s = "00" + s;
        } else if (s.length() == 2) {
            s = "0" + s;
        }

        System.out.println(s);
    }
}
