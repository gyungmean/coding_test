class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;

        long pulse1 = 0; // 1, -1, 1, -1 ... 
        long pulse2 = 0; // -1, 1, -1, 1 ...

        for (int num : sequence) {
            long nextPulse1 = Math.max(pulse2, 0) + num;
            long nextPulse2 = Math.max(pulse1, 0) - num;

            pulse1 = nextPulse1;
            pulse2 = nextPulse2;

            answer = Math.max(answer, Math.max(pulse1, pulse2));
        }

        return answer;
    }
}