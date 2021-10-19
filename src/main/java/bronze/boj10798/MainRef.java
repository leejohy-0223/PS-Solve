package bronze.boj10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readers = new String[5];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (String reader : readers) {
                if (i < reader.length()) {
                    sb.append(reader.charAt(i));
                }
            }
        }
        System.out.println(sb);

    }
}
