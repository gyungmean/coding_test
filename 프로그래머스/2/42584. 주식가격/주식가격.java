import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < prices.length; i++) {
            int count = 0;
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                int idx = s.pop();
                answer[idx] = i - idx;
            }
            s.push(i);
        }
        while(!s.isEmpty()) {
            int idx = s.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        return answer;
    }
}