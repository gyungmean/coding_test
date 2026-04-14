
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < number.length(); i++) {
            int now = Integer.parseInt(number.substring(i, i + 1));
            while(!dq.isEmpty() && k > 0 && dq.peekLast() < now) {
                dq.pollLast();
                k--;
            }
            dq.addLast(now);
        }
        while(k > 0) {
            dq.pollLast();
            k--;
        }
        while(!dq.isEmpty()) {
            answer.append(dq.pollFirst());
        }
        return answer.toString();
    }
    
}