package gold.boj11662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double ax = Double.parseDouble(st.nextToken());
        double ay = Double.parseDouble(st.nextToken());
        double bx = Double.parseDouble(st.nextToken());
        double by = Double.parseDouble(st.nextToken());
        double cx = Double.parseDouble(st.nextToken());
        double cy = Double.parseDouble(st.nextToken());
        double dx = Double.parseDouble(st.nextToken());
        double dy = Double.parseDouble(st.nextToken());

        int interval = 1000000;

        double aDX = (bx - ax) / interval;
        double aDY = (by - ay) / interval;
        double cDX = (dx - cx) / interval;
        double cDY = (dy - cy) / interval;

        double MIN = getDistance(ax, ay, cx, cy);
        for (int i = 1; i <=interval ; i++) {
            double tmp = getDistance(ax + aDX * i, ay + aDY * i, cx + cDX * i, cy + cDY * i);

            if (tmp < MIN) {
                MIN = tmp;
            }
        }
        System.out.println(MIN);
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
