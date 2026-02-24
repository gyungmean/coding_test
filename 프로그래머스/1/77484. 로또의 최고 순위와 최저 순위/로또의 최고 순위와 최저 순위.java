import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];
        int[] rank = new int[]{ 6, 6, 5, 4, 3, 2, 1 };
        
        Set<Integer> win = new HashSet<>();
        for(int n : win_nums) {
            win.add(n);
        }
        int randomNum = 0, count = 0;
        for(int l : lottos) {
            if(l == 0) {
                randomNum++;
                continue;
            }
            if(win.contains(l)) {
                count++;
            }
        }
        answer[0] = rank[count + randomNum] < rank[count] ? rank[count + randomNum] : rank[count];
        answer[1] = rank[count + randomNum] < rank[count] ? rank[count] : rank[count + randomNum];
        
        return answer;
    }
}