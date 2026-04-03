class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int[] weight = {781, 156, 31, 6, 1};
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < 5; j++) {
                if(word.charAt(i) == vowels[j]) {
                    answer += j * weight[i] + 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}