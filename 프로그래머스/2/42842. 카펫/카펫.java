import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int r = 0, c = 0;
        int rowCount = 1;
        while(yellow >= rowCount){
            if(yellow % rowCount == 0) {
                int newColCount = yellow / rowCount;
                int calcBrown = (newColCount * 2) + (rowCount * 2) + 4;
                if(calcBrown == brown) {
                    r = newColCount + 2;
                    c = rowCount + 2;
                    break;
                }
            }
            rowCount++;
        }
        int[] answer = {r, c};
        return answer;
        
    }
}