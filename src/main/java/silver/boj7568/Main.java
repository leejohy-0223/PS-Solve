package silver.boj7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Spec {
    int height;
    int weight;

    public Spec(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Spec[] arr = new Spec[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Spec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;

            Spec now = arr[i];
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                Spec temp = arr[j];

                if (now.height < temp.height && now.weight < temp.weight) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);

    }
}
