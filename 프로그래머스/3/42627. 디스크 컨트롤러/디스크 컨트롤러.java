import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int nowTime = 0;
        int totalTime = 0;
        int jobIndex = 0;
        int jobCount = 0;
        
        while(jobCount < jobs.length) {
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= nowTime) {
                pq.add(new Job(jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex++;
            }
            
            if(pq.isEmpty()) {
                nowTime = jobs[jobIndex][0];
            }
            else {
                Job nowJob = pq.poll();
                int waitTime = (nowTime - nowJob.insertTime) + nowJob.taskTime;
                nowTime += nowJob.taskTime;
                totalTime += waitTime;
                jobCount++;
            }
        }
        
        return totalTime / jobs.length;
    }
    class Job implements Comparable<Job> {
        int insertTime;
        int taskTime;
        public Job (int insertTime, int taskTime) {
            this.insertTime = insertTime;
            this.taskTime = taskTime;
        }
        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.taskTime, o.taskTime);
        }
    }
}