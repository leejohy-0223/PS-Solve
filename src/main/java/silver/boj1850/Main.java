package silver.boj1850;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num1 = sc.nextLong();
        long num2 = sc.nextLong();

        long gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2));

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= gcd; i++) sb.append("1");

        System.out.println(sb.toString());

    }

    public static long getGCD(long a, long b) {
        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}
