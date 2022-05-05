package AlgorithmStudy.pro42860;

// 다시 풀이 필요
public class Solution {
    static boolean[] chk;
    static int answer = 0;

    public int solution(String name) {
        int L = name.length();
        chk = new boolean[L];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < L; i++) {
            sb.append('A');
        }

        int idx = 0;
        while (!sb.toString().equals(name)) {
            //현 위치 기준, 가장 가까운 변경 예정 인덱스로 이동한다.
            idx = find_index(name, idx);

            if (idx == -1) {
                break;
            }

            // 변경할 수 있는 최소 거리를 찾아 answer에 넣는다.
            answer += find_value(sb.charAt(idx), name.charAt(idx));

            // 실제로 sb에 반영한다.
            sb.setCharAt(idx, name.charAt(idx));

            // 변경된 인덱스로 표시한다.
            chk[idx] = true;
        }

        return answer;
    }

    private int find_index(String name, int idx) {
        for(int i = idx; i<name.length(); i++) {
            if(!chk[i] && (name.charAt(i) != 'A')) {
                answer += Math.min(i - idx, (idx + 1 + name.length() - 1 - i));
                return i;
            }
        }
        return -1;
    }

    private int find_value(char current, char target) {
        return Math.min(target - current, (current - 'A' + 1 + 'Z' - target));
    }
}
