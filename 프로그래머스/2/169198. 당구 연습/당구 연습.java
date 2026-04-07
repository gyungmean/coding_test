import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for(int i = 0; i < balls.length; i++) {
            int endX = balls[i][0];
            int endY = balls[i][1];
            //상
            if(!(startX == endX && endY > startY)) {
                answer[i] = (int)Math.pow((startX - endX), 2) + (int)Math.pow((2 * n - endY - startY), 2);
            }
            //하
            if(!(startX == endX && endY < startY)) {
                answer[i] = Math.min(answer[i], (int)Math.pow((startX - endX), 2) + (int)Math.pow((startY + endY), 2));
            }
            //좌
            if(!(startY == endY && endX < startX)) {
                answer[i] = Math.min(answer[i], (int)Math.pow((startY - endY), 2) + (int)Math.pow((startX + endX), 2));
            }
            //우
            if(!(startY == endY && endX > startX)) {
                answer[i] = Math.min(answer[i], (int)Math.pow((startY - endY), 2) + (int)Math.pow((2 * m - endX - startX), 2));
            }
        }
        return answer;
    }
}