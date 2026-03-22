import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numbers.length; i++) {
            while(!q.isEmpty() && numbers[q.peekLast()] < numbers[i]) {
                int idx = q.pollLast();
                answer[idx] = numbers[i];
            }
            q.offerLast(i);
        }
            
        return answer;
    }
}