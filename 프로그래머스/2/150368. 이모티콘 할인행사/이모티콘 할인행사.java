import java.util.*;
class Solution {
    int maxSell = 0, maxEmoPlus = 0;
    public int[] solution(int[][] users, int[] emoticons) {

        find(new int[emoticons.length], 0, users, emoticons);
        int[] answer = {maxEmoPlus, maxSell};
        return answer;
    }
    
    void find(int[] nowDiscount, int nowEmoticon, int[][] users, int[] emoticons) {
        if(nowEmoticon == emoticons.length) {
            int[] personalSum = new int[users.length];
            for(int i = 0; i < emoticons.length; i++) {
                for(int j = 0; j < users.length; j++) {
                    if((nowDiscount[i] + 1) * 10 >= users[j][0]) {
                        //구매함
                        int price = emoticons[i] * (100 - (nowDiscount[i] + 1) * 10) / 100;
                        personalSum[j] += price;
                    }
                }
            }
            int tmpSell = 0, tmpEmoPlus = 0;
            for(int i = 0; i < users.length; i++) {
                if(personalSum[i] >= users[i][1]) {
                    tmpEmoPlus++;
                }
                else {
                    tmpSell += personalSum[i];
                }
            }
            if(tmpEmoPlus > maxEmoPlus) {
                maxEmoPlus = tmpEmoPlus;
                maxSell = tmpSell;
            }
            else if(tmpEmoPlus == maxEmoPlus) {
                maxSell = Math.max(maxSell, tmpSell);
            }
            
            return;
        }
        for(int i = 0; i < 4; i++) {
            nowDiscount[nowEmoticon] = i;
            find(nowDiscount, nowEmoticon + 1, users, emoticons);
        }
    }
}