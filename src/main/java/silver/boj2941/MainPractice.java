package silver.boj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        str = str.replaceAll("c=", "A");
        str = str.replaceAll("c-", "A");
        str = str.replaceAll("dz=", "A");
        str = str.replaceAll("d-", "A");
        str = str.replaceAll("lj", "A");
        str = str.replaceAll("nj", "A");
        str = str.replaceAll("s=", "A");
        str = str.replaceAll("z=", "A");


        System.out.println(str.length());
    }
}
