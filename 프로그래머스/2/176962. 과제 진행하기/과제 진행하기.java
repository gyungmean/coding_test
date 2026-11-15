import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Plan[] sorted = new Plan[plans.length];

        for (int i = 0; i < plans.length; i++) {
            sorted[i] = new Plan(
                plans[i][0],
                toMinutes(plans[i][1]),
                Integer.parseInt(plans[i][2])
            );
        }

        Arrays.sort(sorted, Comparator.comparingInt(p -> p.start));

        List<String> finished = new ArrayList<>();
        Deque<Plan> paused = new ArrayDeque<>();

        for (int i = 0; i < sorted.length - 1; i++) {
            Plan current = sorted[i];
            int available = sorted[i + 1].start - current.start;

            if (current.duration > available) {
                // 다음 과제 시작 전에 끝내지 못하면 남은 시간을 저장
                current.duration -= available;
                paused.push(current);
            } else {
                // 현재 과제를 끝냄
                finished.add(current.subject);
                int spare = available - current.duration;

                // 남는 시간으로 멈춘 과제들을 최근 순서대로 진행
                while (spare > 0 && !paused.isEmpty()) {
                    Plan prev = paused.pop();

                    if (prev.duration <= spare) {
                        spare -= prev.duration;
                        finished.add(prev.subject);
                    } else {
                        prev.duration -= spare;
                        paused.push(prev);
                        spare = 0;
                    }
                }
            }
        }

        // 마지막 과제는 시작 후 방해받지 않으므로 먼저 완료
        finished.add(sorted[sorted.length - 1].subject);

        // 이후 멈춰 둔 과제는 최근에 멈춘 순서대로 완료
        while (!paused.isEmpty()) {
            finished.add(paused.pop().subject);
        }

        return finished.toArray(new String[0]);
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

class Plan {
    String subject;
    int start;
    int duration;

    Plan(String subject, int start, int duration) {
        this.subject = subject;
        this.start = start;
        this.duration = duration;
    }
}