package programmers.pro92341;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    private final Map<String, Car> feeMap = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] info = record.split(" ");
            int minute = makeMinute(info[0]);
            Car curCar = feeMap.getOrDefault(info[1], new Car(fees[1]));
            if (info[2].equals("IN")) {
                curCar.inMinute(minute);
            } else {
                curCar.addMinute(minute);
            }
            feeMap.put(info[1], curCar);
        }

        // 요금 계산
        int lastMinute = 1439;
        for (Car value : feeMap.values()) {
            if (value.inMinute != -1) {
                value.addMinute(lastMinute);
            }
            int sumMinute = value.getSumMinute();
            int restOfTheTime = sumMinute - fees[0];
            if (restOfTheTime > 0) {
                value.addFee((restOfTheTime % fees[2] == 0 ? restOfTheTime / fees[2] : restOfTheTime / fees[2] + 1) * fees[3]);
            }
        }

        // 차량 번호 순으로 정렬
        List<String> keys = feeMap.keySet().stream().sorted().collect(Collectors.toList());

        int[] answer = new int[keys.size()];
        int idx = 0;
        for (String key : keys) {
            answer[idx++] = feeMap.get(key).getSumFee();
        }
        return answer;
    }

    private int makeMinute(String times) {
        String[] timeInfo = times.split(":");
        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }

    static class Car {
        private int sumFee;
        private int sumMinute = 0;
        private int inMinute = 0;

        public Car(int sumFee) {
            this.sumFee = sumFee;
        }

        public int getSumFee() {
            return sumFee;
        }

        public int getSumMinute() {
            return sumMinute;
        }

        public void inMinute(int minute) {
            this.inMinute = minute;
        }

        public void addMinute(int minute) {
            sumMinute += (minute - inMinute);
            inMinute = -1;
        }

        public void addFee(int fee) {
            sumFee += fee;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] results = solution.solution(new int[] {180, 5000, 10, 600},
        //     new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
        //         "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        int[] results = solution.solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"});

        for (int result : results) {
            System.out.println("result = " + result);
        }
    }
}
