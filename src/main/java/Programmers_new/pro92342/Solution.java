package Programmers_new.pro92342;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static List<int[]> answers = new ArrayList<>();
    static int[] gameResult = new int[11];
    static int[] gameScore;
    static int[] apeachScore;
    static int N;
    static int maxValue = 0;

    public int[] solution(int n, int[] info) {
        apeachScore = info.clone();
        N = n;
        permu(0);

        if (maxValue == 0) {
            return new int[] {-1};
        }

        answers.sort(((o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        }));

        return answers.get(0);
    }

    private void permu(int now) {
        if (now == 11) {
            // 만들어진 라이언의 승리 정보에 맞게 시뮬레이션을 진행해본다.
            int remain = N;
            int apeach = 0, lion = 0;
            gameScore = new int[11];
            for (int i = 0; i < 11; i++) {
                // 화살이 없다면, 어피치가 한발이라도 맞춘 경우를 모두 어피치 점수로 넣는다.
                if (remain == 0) {
                    for (int j = i; j < 11; j++) {
                        if (apeachScore[j] != 0) {
                            apeach += (10 - j);
                        }
                    }
                    break;
                }
                // 져야하는 판이면 화살을 아낀다.
                if (gameResult[i] == 0) {
                    apeach += (10 - i);
                    continue;
                }
                // 이겨야하는 판이라면, 우선 해당 수 만큼 화살에서 뺀다
                remain -= (apeachScore[i] + 1); // 1만큼 더 커야 이길 수 있다.

                // 남은 화살이 0보다 작으면 나가리~~
                if (remain < 0) {
                    for (int j = i; j < 11; j++) {
                        if (apeachScore[j] != 0) {
                            apeach += (10 - j);
                        }
                    }
                    break;
                }
                // 이기는게 가능하다면, 점수 및 사용판에 적용
                lion += (10 - i);
                gameScore[i] = (apeachScore[i] + 1);
            }

            if (remain > 0) {
                gameScore[10] = remain;
            }

            // 화살 정산
            if (lion > apeach) {
                if (maxValue < (lion - apeach)) {
                    maxValue = (lion - apeach);
                    answers.clear();
                    answers.add(gameScore.clone());
                    return;
                }
                if (maxValue == (lion - apeach)) {
                    answers.add(gameScore.clone());
                }
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            gameResult[now] = i;
            permu(now + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] solution = s.solution(5, new int[] {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        // int[] solution = s.solution(1, new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        int[] solution = s.solution(9, new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
        // int[] solution = s.solution(10, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
