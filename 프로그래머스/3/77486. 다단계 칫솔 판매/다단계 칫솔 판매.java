import java.util.*;
class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parents = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
        }
        Map<String, Integer> money = new HashMap<>();
        for(int i = 0; i < seller.length; i++) {
            String nowPerson = seller[i];
            int price = amount[i] * 100;
            
            while(!nowPerson.equals("-") && price > 0) {
                int comission = price / 10;
                int mine = price - comission;
                money.put(nowPerson, money.getOrDefault(nowPerson, 0) + mine);
                
                nowPerson = parents.get(nowPerson);
                price = comission;
            } 
        }

        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = money.getOrDefault(enroll[i], 0);
        }
        

        return answer;
    }
    

}