import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        Arrays.sort(book_time, (t1, t2) -> {
            int startTime1 = timeConvert(t1[0]);
            int startTime2 = timeConvert(t2[0]);

            if(startTime1 == startTime2) {
                return timeConvert(t1[1]) - timeConvert(t2[1]);
            }
            return startTime1 - startTime2;
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String[] time : book_time) {
            int start = timeConvert(time[0]);
            int end = timeConvert(time[1]) + 10; 

            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll(); 
            }
            pq.offer(end);
        }

        return pq.size();
    }
    
    int timeConvert(String t) {
        String[] tmp = t.split(":");
        int h = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        return h * 60 + m;
    }
}