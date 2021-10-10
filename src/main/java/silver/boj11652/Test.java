package silver.boj11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));

        int N = 3;
        while(N-- > 0) {
            long i = Long.parseLong(sb.readLine());
            if(i < 0) {
                System.out.println("음수 ");
            }
        }
    }
}
