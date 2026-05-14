class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        for(int i = n + 1; i <= 1000000; i++) {
            if(count == Integer.bitCount(i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}