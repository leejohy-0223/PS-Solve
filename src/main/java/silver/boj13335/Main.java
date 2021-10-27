package silver.boj13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Truck {
    int weight;
    int position;

    public Truck(int weight, int position) {
        this.weight = weight;
        this.position = position;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 하중

        st = new StringTokenizer(br.readLine());
        Truck[] truck = new Truck[n];
        List<Truck> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            truck[i] = new Truck(Integer.parseInt(st.nextToken()), w);
        }

        int time = 0;
        int idx = 0;
        int weight = 0;

        while (idx < n) {
            time++;
            // 리스트의 트럭 포지션을 하나씩 낮춰준다.
            for (Truck t : list) {
                t.position--;
            }

            // 리스트의 맨 첫번째 position이 0일 경우, 무게를 줄이고 list에서 제거한다.
            if (!list.isEmpty() && list.get(0).position == 0) {
                weight -= list.get(0).weight;
                list.remove(0);
            }

            if(weight + truck[idx].weight <= l) {
                weight += truck[idx].weight;
                list.add(new Truck(truck[idx].weight, w));
                idx++;
            }
        }
        // 마지막 인덱스가 올라온 후, 탈출 시간을 더해준다.
        System.out.println(time + w);
    }
}

