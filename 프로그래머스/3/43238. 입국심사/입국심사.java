import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0;
        long end = 0;
        
        for(int t : times){
            end = Math.max(end, t);
        }
        end *= n;
        
        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;
            
            for(int t : times){
                cnt += mid / t;
            }
            
            if(cnt >= n){
                end = mid - 1;
                answer = mid;
            }
            else{
                start = mid + 1;
            }
        }
        
        return answer;
    }
}