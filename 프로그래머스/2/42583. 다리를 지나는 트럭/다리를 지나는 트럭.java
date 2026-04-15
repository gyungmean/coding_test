import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int nowTruckWeightSum = 0;
        for(int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        int i = 0;
        while(i < truck_weights.length) {
            nowTruckWeightSum -= q.poll();
            int nowTruckWeight = truck_weights[i];
            if(nowTruckWeight + nowTruckWeightSum <= weight) {
                q.add(nowTruckWeight);
                nowTruckWeightSum += nowTruckWeight;
                i++;
            }
            else {
                q.add(0);
            }
            answer++;
        }
        while(!q.isEmpty() && nowTruckWeightSum != 0) {
            nowTruckWeightSum -= q.poll();
            answer++;
        }
        return answer;
    }
}