package silver.boj4673;

public class MainChange {
    static boolean[] chk = new boolean[10001];
    public static void main(String[] args) {

        for (int i = 1; i <= 10000 ; i++) {
            if(chk[i]) {
                continue;
            }
            iterSelf(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            if(!chk[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void iterSelf(int i) {
        if(i > 10000) {
            return;
        }
        int sum = i;

        while(i!=0) {
            sum += i % 10;
            i /= 10;
        }
        chk[sum] = true;
        iterSelf(sum);
    }
}
