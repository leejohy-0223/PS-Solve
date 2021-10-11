package bronze.boj11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Stack<Long> stack = new Stack<>();

        while(N >= B) {
            stack.push(N % B);
            N /= B;
        }
        StringBuilder sb = new StringBuilder();
        if(N >= 10) {
            char l = (char) ('A' + N - 10);
            sb.append(l);
        } else
            sb.append(N);

        while(!stack.isEmpty()) {
            Long pop = stack.pop();
            if(pop >= 10) {
                sb.append((char) (pop + 'A' - 10)); // (char) (pop + 55)
            } else
                sb.append(pop);
        }
        System.out.println(sb);
    }
}
