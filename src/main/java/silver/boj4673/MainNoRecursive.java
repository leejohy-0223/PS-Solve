package silver.boj4673;

public class MainNoRecursive {

    static boolean[] chk = new boolean[10001];

    public static void main(String[] args) {

        for(int i=1; i<=10000; i++) {
            int n = d(i);
            if(n<=10000) {
                chk[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            if (!chk[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static int d(int n) {
        int sum = n;
        while(n!=0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
