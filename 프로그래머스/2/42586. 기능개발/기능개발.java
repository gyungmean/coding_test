import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int idx = 0;

        while (idx < progresses.length) {
            int days = (100 - progresses[idx] + speeds[idx] - 1) / speeds[idx];
            idx++;

            int count = 1;
            while (idx < progresses.length) {
                int nextDays = (100 - progresses[idx] + speeds[idx] - 1) / speeds[idx];

                if (nextDays > days) break;

                count++;
                idx++;
            }

            answerList.add(count);
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}