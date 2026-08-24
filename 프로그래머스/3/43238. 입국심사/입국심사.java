import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long min = 0;
        long max = 0;
        for(int t : times) {
            max = Math.max(t, max);
        }
        max *= n;
        
        while(min <= max){
            long mid = (min + max) / 2;
            long cnt = 0;
            
            for(int t : times){
                cnt += mid / t;
            }
            
            if(cnt >= n){
                max = mid - 1;
                answer = mid;
            }
            else{
                min = mid + 1;
            }
        }
        
        return answer;
    }
}