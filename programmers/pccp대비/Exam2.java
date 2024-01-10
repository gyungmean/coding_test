import java.util.*;
class Exam2 {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : ability){
            pq.add(n);
        }
        for(int i = 0; i < number; i++){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }
        int answer = 0;
        for(int n : pq){
            answer += n;
        }
        return answer;
    }
}
