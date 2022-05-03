package Programmers_new.pro92342;

import java.util.Arrays;

public class Combination {

    public static void main(String[] ar) {

        ComparableTest test1 = new ComparableTest(1);
        ComparableTest test2 = new ComparableTest(5);
        ComparableTest[] arr = new ComparableTest[] { test1, test2 };

        System.out.print("정렬 전 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getA() + " ");
        }

        Arrays.sort(arr);

        System.out.print("\n정렬 후 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getA() + " ");
        }
    }
}

class ComparableTest implements Comparable<ComparableTest> {

    private int a;

    public ComparableTest(int a) {
        super();
        this.a = a;
    }

    @Override
    public int compareTo(ComparableTest o) {

        if (this.a < o.a) {
            System.out.println("\nthis : " + this.a + ", o : " + o.a + "");
            System.out.println("리턴값 : 1");
            return 1;
        }

        // 예상과 다르게 여기가 실행된다.
        System.out.println("\nthis : " + this.a + ", o : " + o.a + "");
        System.out.println("리턴값  : -1");
        return -1;
    }

    public int getA() {
        return a;
    }
}
