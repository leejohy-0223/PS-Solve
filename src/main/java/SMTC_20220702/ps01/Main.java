package SMTC_20220702.ps01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        List<VillageInfo> lists = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            lists.add(new VillageInfo());
        }

        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            lists.get(i).setMonsterHealth(Integer.parseInt(secondLine[i]));
        }

        String[] thirdLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            lists.get(i).setPeopleCount(Integer.parseInt(thirdLine[i]));
        }
        Collections.sort(lists);

        int result = 0;

        for (int i = 0; i < N; i++) {
            // 시작점
            VillageInfo start = lists.get(i);
            // 남은 체력
            int remainingStamina = K - start.getMonsterHealth();
            if (remainingStamina < 0) {
                continue;
            }
            // 구한 사람 수
            int savedPeopleCount = start.getPeopleCount();

            // 누적된 몬스터
            int accumulate = start.getMonsterHealth();
            for (int j = i + 1; j < N; j++) {
                VillageInfo nextVillage = lists.get(j);
                accumulate += nextVillage.getMonsterHealth();
                remainingStamina -= accumulate;

                // 남은 체력이 0보다 적다면, 지금까지의 구한 사람수를 갱신한다.
                if (remainingStamina < 0) {
                    break;
                }
                // 충분하다면, 사람수를 갱신한다.
                savedPeopleCount += nextVillage.getPeopleCount();
            }
            result = Math.max(result, savedPeopleCount);
        }

        System.out.println(result);
    }

    static class VillageInfo implements Comparable<VillageInfo> {
        private int monsterHealth;
        private int peopleCount;

        public void setMonsterHealth(int monsterHealth) {
            this.monsterHealth = monsterHealth;
        }

        public void setPeopleCount(int peopleCount) {
            this.peopleCount = peopleCount;
        }

        public int getMonsterHealth() {
            return monsterHealth;
        }

        public int getPeopleCount() {
            return peopleCount;
        }

        @Override
        public int compareTo(VillageInfo o) {
            if (this.peopleCount == o.peopleCount) {
                return this.monsterHealth - o.monsterHealth;
            }
            return o.peopleCount - this.peopleCount;
        }
    }
}


