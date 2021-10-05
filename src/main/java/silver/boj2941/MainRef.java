package silver.boj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRef {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '=':
                    switch (str.charAt(i - 1)) {
                        case 'c': case 's': count++; break;
                        case 'z':
                            if(i > 1 && str.charAt(i - 2) == 'd') {
                                count += 2;
                                break;
                            } else {
                                count ++;
                                break;
                            }
                        default: break;
                    }
                    break;
                case '-':
                    switch (str.charAt(i - 1)) {
                        case 'c': case 'd': count++; break;
                        default: break;
                    }
                    break;
                case 'j':
                    switch (str.charAt(i - 1)) {
                        case 'l': case 'n': count++; break;
                        default: break;
                    }
                    break;
                default: break;
            }
        }
        System.out.print(str.length() - count);
    }
}
