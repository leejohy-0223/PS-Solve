package silver.boj20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainRef {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static Belt[] belt;
    static int newSize;

    private static class Belt {
        int power;
        boolean isRobotHere;

        public Belt(int power, boolean isRobotHere) {
            this.power = power;
            this.isRobotHere = isRobotHere;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        newSize = N << 1;

        belt = new Belt[newSize];
        for (int i = 0; i < newSize; i++) {
            belt[i] = new Belt(Integer.parseInt(st.nextToken()), false);
        }

        System.out.println(move());
    }

    private static int move() {
        int Dan = 0;
        while (true) {
            Dan++;
            rotate();
            moveRobot();
            robotStart();
            if (isK()) {
                break;
            }
        }
        return Dan;
    }

    private static boolean isK() {
        int count = 0;
        for (int i = 0; i < newSize; i++) {
            if (belt[i].power == 0) {
                count++;
            }
            if (count == K) {
                return true;
            }
        }
        return false;
    }

    private static void robotStart() {
        if (belt[0].power > 0) {
            belt[0].power--;
            belt[0].isRobotHere = true;
        }
    }

    private static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (belt[i].isRobotHere) {
                if (i + 1 == N - 1) {
                    if (belt[i + 1].power > 0) { // 맨 끝은 power만 확인(항상 비워져있음)
                        belt[i].isRobotHere = false;
                        belt[i + 1].power--;
                        continue;
                    }
                }
                if (!belt[i + 1].isRobotHere && belt[i + 1].power > 0) {
                    belt[i].isRobotHere = false;
                    belt[i + 1].isRobotHere = true;
                    belt[i + 1].power--;
                }
            }
        }

    }

    private static void rotate() {
        int powerTemp = belt[newSize - 1].power;
        belt[N-1].isRobotHere = false; // 회전시키기 전, 내려가는 위치는 초기화

        for (int i = newSize - 1; i >= 1; i--) {
            // 얕은 복사 진행
            belt[i].isRobotHere = belt[i - 1].isRobotHere;
            belt[i].power = belt[i - 1].power;

        }
        belt[0].isRobotHere = false;
        belt[0].power = powerTemp;
    }
}
