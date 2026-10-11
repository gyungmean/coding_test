class Solution {
    public int solution(int n, int[] stations, int w) {
        //나보다 왼쪽만봐
        //남은 거리 / (w * 2 + 1) + 1
        int answer = 0;

        int lastIdx = 1;
        for(int i = 0; i < stations.length; i++) {
            int start = stations[i] - w - 1;
            int length = start - lastIdx + 1;
            if(length > 0) {
                answer += (length / (w * 2 + 1));
                if(length % (w * 2 + 1) != 0) {
                    answer++;
                }   
            }
            lastIdx = stations[i] + w + 1;
        }
        if(lastIdx <= n) {
            //System.out.println((n - lastIdx + 1));
            int length = n - lastIdx + 1;
            answer += (length / (w * 2 + 1));
            if(length % (w * 2 + 1) != 0) {
                answer++;
            }
        }

        return answer;
    }
}