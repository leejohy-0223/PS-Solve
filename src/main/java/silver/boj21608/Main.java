package silver.boj21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] seats = new int[N][N];

        int number = N * N;

        StringTokenizer st;
        while (number-- > 0) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            map.put(student, new ArrayList<>());
            for (int i = 0; i < 4; i++) {
                map.get(student).add(Integer.parseInt(st.nextToken())); // 1. 이후에 map을 기반으로 만족도를 조사할 때도 활용된다.
            }
            // 1단계. 주변의 좋아하는 학생 수를 세기
            List<Position> list = new ArrayList<>();
            int maxCount = 0;
            int count;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(seats[i][j] != 0) continue;
                    count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            if (map.get(student).contains(seats[nx][ny])) {
                                count++;
                            }
                        }
                    }
                    // 아래 과정을 통해 최종적으로 count가 가장 많은 수들의 list가 생성된다. 처음에는 0이므로 모든 i, j가 들어가게 된다.
                    if (maxCount < count) {
                        maxCount = count;
                        list.clear();
                        list.add(new Position(i, j));
                    } else if (maxCount == count) {
                        list.add(new Position(i, j));
                    }
                }
            }

            // 1차적으로, 1단계를 만족한 죄표를 걸러내고 continue를 수행한다.
            if (list.size() == 1) {
                Position p = list.get(0);
                seats[p.x][p.y] = student;
                continue;
            }

            // 2단계
            // 이로써 list에는 좋아하는 사람이 가장 많은 자리 목록 여러명이 나온다.
            // 걸러진 위치를 대상으로, 비워있는 가장 많은 칸을 다시 리스트에 담는다.
            List<Position> secondList = new ArrayList<>();
            maxCount = 0;
            for (Position p : list) {
                count = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && seats[nx][ny] == 0) {
                        count++;
                    }
                }
                // 마찬가지로 최대 count를 가지는 위치만 secondList에 담는다.
                if (maxCount < count) {
                    maxCount = count;
                    secondList.clear();
                    secondList.add(new Position(p.x, p.y));
                } else if (maxCount == count) {
                    secondList.add(new Position(p.x, p.y));
                }
            }

            // 1차적으로, 1단계를 만족한 죄표를 걸러내고 continue를 수행한다.
            if (secondList.size() == 1) {
                Position p = secondList.get(0);
                seats[p.x][p.y] = student;
                continue;
            }

            // 3 단계
            // 2를 만족하는 칸도 여러개인 경우에는, 행 -> 열이 작은 칸으로 자리를 정한다.
            secondList.sort((o1, o2) -> {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            });

            Position p = secondList.get(0);
            seats[p.x][p.y] = student;
        }

        // 이제 정해진 자리를 바탕으로, 만족도를 조사한다.
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = seats[i][j];
                int count = 0;
                List<Integer> list = map.get(cur);

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (list.contains(seats[nx][ny])) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    sum += 1;
                } else if (count == 2) {
                    sum += 10;
                } else if (count == 3) {
                    sum += 100;
                } else if (count == 4) {
                    sum += 1000;
                }
            }
        }
        System.out.println(sum);
    }
}
