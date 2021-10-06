package silver.boj4673;

public class Main {

    static boolean[] chk = new boolean[20001];
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

        String cp = i + ""; // i = 1
        String[] split = cp.split("");

        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        chk[i + sum] = true;
        iterSelf(i + sum);
    }
}
