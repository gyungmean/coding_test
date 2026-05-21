class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];
        
        for (long i = begin; i <= end; i++) {
            int idx = (int)(i - begin);
            
            if (i == 1) {
                answer[idx] = 0;
                continue;
            }
            
            int maxBlock = 1; 

            for (long j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    if (i / j <= 10000000) {
                        maxBlock = (int)(i / j);
                        break; 
                    }
                    
                    if (j <= 10000000) {
                        maxBlock = Math.max(maxBlock, (int)j);
                    }
                }
            }
            answer[idx] = maxBlock;
        }
        
        return answer;
    }
}