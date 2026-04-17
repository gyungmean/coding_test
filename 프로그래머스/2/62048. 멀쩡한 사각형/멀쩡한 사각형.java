class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcf = getGcf(w, h);

        answer = (long)w * h - (w + h - gcf);
        return answer;
    }
    
    public int getGcf(int w, int h){
        int a = w > h ? w : h;
        int b = w > h ? h : w;
        
        int tmp = a % b;
        if(tmp == 0) {return b;}
        while(tmp != 0){
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return b;
    }
}