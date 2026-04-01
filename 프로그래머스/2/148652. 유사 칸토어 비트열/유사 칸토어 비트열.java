import java.util.*;
class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i < r; i++) {
            if(!isZero(i)) {
                answer++;
            }
        }
        return answer;
    }
    boolean isZero(long i) {
        while(i > 0) {
            if(i % 5 == 2) return true;
            i /= 5;
        }
        return false;
    }
}