package silver.boj16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); // 연산의 수

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        while (R-- > 0) {
            int op = Integer.parseInt(st.nextToken());

            int mid;
            int sum;
            int[][] newArr;
            int[][] divArr;
            switch (op) {
                case 1: // 연산 1 (상하 반전)
                    mid = arr.length / 2 - 1;
                    sum = 1;
                    for (int i = mid; i >= 0; i--) {
                        for (int j = 0; j < arr[0].length; j++) {
                            int target = sum + i;
                            int tmp = arr[i][j];
                            arr[i][j] = arr[target][j];
                            arr[target][j] = tmp;
                        }
                        sum += 2;
                    }
                    break;

                case 2: // 연산 2 (좌우 반전)
                    mid = arr[0].length / 2 - 1;
                    sum = 1;
                    for (int i = mid; i >= 0; i--) {
                        for (int j = 0; j < arr.length; j++) {
                            int target = sum + i;
                            int tmp = arr[j][i];
                            arr[j][i] = arr[j][target];
                            arr[j][target] = tmp;
                        }
                        sum += 2;
                    }
                    break;

                case 3: // 연산 3 (90도 왼쪽 회전)
                    newArr = new int[arr[0].length][arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[0].length; j++) {
                            newArr[j][arr.length - 1 - i] = arr[i][j];
                        }
                    }
                    arr = newArr;
                    break;

                case 4: // 연산 4 (90도 오른쪽 회전)
                    newArr = new int[arr[0].length][arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[0].length; j++) {
                            newArr[arr[0].length - 1 - j][i] = arr[i][j];
                        }
                    }
                    arr = newArr;
                    break;

                case 5: // 연산 5 (4등분 & 시계방향)
                    divArr = new int[arr.length / 2][arr[0].length / 2];
                    for (int i = 0; i < arr.length / 2; i++) {
                        for (int j = 0; j < arr[0].length / 2; j++) {
                            divArr[i][j] = arr[i][j];
                        }
                    }
                    // 4 -> 1 ( j는 동일, i만 변경)
                    for (int i = arr.length / 2; i < arr.length; i++) {
                        for (int j = 0; j < arr[0].length / 2; j++) {
                            arr[i - arr.length / 2][j] = arr[i][j];
                        }
                    }

                    // 3 -> 4 ( i는 동일, j만 변경)
                    for (int i = arr.length / 2; i < arr.length; i++) {
                        for (int j = arr[0].length / 2; j < arr[0].length; j++) {
                            arr[i][j - arr[0].length / 2] = arr[i][j];
                        }
                    }

                    // 2 -> 3(j는 동일, i만 변경)
                    for (int i = 0; i < arr.length / 2; i++) {
                        for (int j = arr[0].length / 2; j < arr[0].length; j++) {
                            arr[i + arr.length / 2][j] = arr[i][j];
                        }
                    }

                    // 1 -> 2
                    for (int i = 0; i < arr.length / 2; i++) {
                        for (int j = 0; j < arr[0].length / 2; j++) {
                            arr[i][j + arr[0].length / 2] = divArr[i][j];
                        }
                    }
                    break;

                case 6: // 연산 6 (4등분 & 반시계 방향)
                    divArr = new int[arr.length / 2][arr[0].length / 2];
                    for (int i = 0; i < arr.length / 2; i++) {
                        for (int j = 0; j < arr[0].length / 2; j++) {
                            divArr[i][j] = arr[i][j];
                        }
                    }
                    // 2 -> 1 ( i는 동일, j만 변경)
                    for (int i = 0; i < arr.length / 2; i++) {
                        for (int j = arr[0].length / 2; j < arr[0].length; j++) {
                            arr[i][j - arr[0].length / 2] = arr[i][j];
                        }
                    }

                    // 3 -> 2 ( j는 동일, i만 변경)
                    for (int i = arr.length / 2; i < arr.length; i++) {
                        for (int j = arr[0].length / 2; j < arr[0].length; j++) {
                            arr[i - arr.length / 2][j] = arr[i][j];
                        }
                    }

                    // 4 -> 3(i는 동일, j만 변경)
                    for (int i = arr.length / 2; i < arr.length; i++) {
                        for (int j = 0; j < arr[0].length / 2; j++) {
                            arr[i][j + arr[0].length / 2] = arr[i][j];
                        }
                    }

                    // 1 -> 4
                    for (int i = 0; i < arr.length / 2; i++) {
                        for (int j = 0; j < arr[0].length / 2; j++) {
                            arr[i + arr.length / 2][j] = divArr[i][j];
                        }
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(ints[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
