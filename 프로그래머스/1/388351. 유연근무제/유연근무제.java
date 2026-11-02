import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int n = 0; n < schedules.length; n++) {
            int hour = schedules[n] / 100;
            int minute = schedules[n] % 100 + 10;

            if (minute >= 60) {
                hour++;
                minute -= 60;
            }

            int targetTime = hour * 100 + minute;
            int count = 0;

            for (int i = 0; i < 7; i++) {
                int day = (startday - 1 + i) % 7; 
                if (day == 5 || day == 6) continue;

                if (timelogs[n][i] <= targetTime) {
                    count++;
                }
            }

            if (count == 5) answer++;
        }

        return answer;
    }
}