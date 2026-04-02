import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();
        Arrays.sort(weights);
        for(int w : weights) {
            answer += map.getOrDefault(w, 0l); //1:1
            //1:2
            if(w % 2 == 0) {
                answer += map.getOrDefault(w / 2, 0l);
            }
            //2:3
            if(w % 3 == 0) {
                answer += map.getOrDefault(w / 3 * 2, 0l);
            }
            //3:4
            if(w % 4 == 0) {
                answer += map.getOrDefault(w / 4 * 3, 0l);
            }
            map.put(w, map.getOrDefault(w, 0l) + 1l);
        }
        
        return answer;
    }
}